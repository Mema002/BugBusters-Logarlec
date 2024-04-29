package src.testing;


import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


import src.character.*;
import src.character.Character;
import src.effect.Cursed;
import src.effect.Effect;
import src.effect.Gassy;
import src.effect.Sticky;
import src.item.*;
import src.room.Room;

//TODO ebben kommenteket kikommentelni, csak fejlesztéshez-megértéshez kell

//TODO a Character Id GLOBÁLIS, karaktertípusokon átívelő id kell hogy legyen. Pl: Janitor A.id = 1, ezután Teacher B.id = 2, ezután Janitor C.id = 3. Kereshetőség miatt ez MUST!!

//Ha látjátok, hogy sír az IDE, hogy "lehet null-ra akarsz függvényt hívni", akkor engedd el, ha helyesek a paraméterek a teszt fájlban, akkor nem lesz null-ra hívva semmi

public class TestFileLoader {

    public TestCase load(String filename) {

        BufferedReader loadedFile = getFile(filename);
        if (loadedFile == null) {
            System.err.println("Kilepunk ebbol a fuggvenybol, mert nem sikerult a fajlt betolteni.");
            return null;
        }


        LinkedHashMap<String, StringBuilder> mainStages = this.parseGameData(loadedFile, "__");

        BufferedReader startStageString = convertToBufferedReader(mainStages.get("__GameInit"));
        BufferedReader endStageString = convertToBufferedReader(mainStages.get("__Endstate"));
        BufferedReader actionsString = convertToBufferedReader(mainStages.get("__Actions"));

        System.out.println("...Building " + filename + " testcase");
        System.out.println("...Building Start state");
        LinkedHashMap<String, StringBuilder> startStateData = this.parseGameData(startStageString, "_");
        State startState = this.toState(startStateData);

        System.out.println("...Building End state");
        LinkedHashMap<String, StringBuilder> endStateData = this.parseGameData(endStageString, "_");
        State endState = this.toState(endStateData);

        System.out.println();
        System.out.println("...Building Actions");
        List<String> actions = actionsString.lines().toList();
        List<TestActionDTO> actionDTOs = toActionDTOs(actions, startState.characters);
        actionDTOs.forEach(System.out::println);


        return new TestCase(startState, endState, actionDTOs);
    }

    private State toState(LinkedHashMap<String, StringBuilder> stateData) {

        List<String> roomsByParams = Arrays.asList(stateData.get("_Rooms").toString().split("\n"));
        List<Room> rooms = new ArrayList<>();
        System.out.println("Roomok felépítése, még szomszédok nélkül");
        roomsByParams.forEach(
            (roomParams)-> {
                String[] params = roomParams.split("-");
                System.out.println(Arrays.toString(params));
                rooms.add(new Room(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
            }
        );

        System.out.println("Roomoknak szomszédok beállítása, ha vannak szomszédok");
        if (!stateData.containsKey("_Roomneighbours")) {
            System.out.println("...Nincs Neighbours a stateData-ben");
        } else {
            System.out.println("Vannak szomszédok");
            List<String> roomNeighboursByIds = Arrays.asList(stateData.get("_Roomneighbours").toString().split("\n"));
            roomNeighboursByIds.forEach(
                    (idsString) -> {
                        String[] ids = idsString.split("-");
                        System.out.println(Arrays.toString(ids));
                        Room room1 =
                                rooms.stream()
                                        .filter(r -> r.getId() == Integer.parseInt(ids[0]))
                                        .findFirst()
                                        .orElse(null);
                        Room room2 =
                                rooms.stream()
                                        .filter(r -> r.getId() == Integer.parseInt(ids[1]))
                                        .findFirst()
                                        .orElse(null);
                        room1.addNeighbour(room2);
                        room2.addNeighbour(room1);
                    }
            );
        }

        System.out.println("Karakterek felépítése");
        List<String> charactersByParams = Arrays.asList(stateData.get("_Characters").toString().split("\n"));
        List<Character> characters = new ArrayList<>();
        charactersByParams.forEach(
            (characterParams)-> {
                String[] params = characterParams.split("-");
                Room room = rooms
                        .stream()
                        .filter(
                            r -> r.getId() == Integer.parseInt(params[2])
                        )
                        .findFirst()
                        .orElse(null);
                System.out.println(Arrays.toString(params));
                switch (params[0]) {
                    case "Student":
                        Student stu = new Student( room, Integer.parseInt(params[1]));
                        characters.add(stu);
                        room.addCharacter(stu);
                        break;
                    case "Teacher":
                        Teacher te = new Teacher( room, Integer.parseInt(params[1]));
                        characters.add(te);
                        room.addCharacter(te);
                        break;
                    case "Janitor":
                        Janitor ja = new Janitor( room, Integer.parseInt(params[1]));
                        characters.add(ja);
                        room.addCharacter(ja);
                        break;
                    default:
                        System.err.println("Hibás character type: " + params[0]);
                }
            }
        );

        System.out.println("Effektek beállítása, ha vannak szomszédok");
        List<Effect> effects = new ArrayList<>();
        if (!stateData.containsKey("_Effects")) {
            System.out.println("...Nincs Effects a stateData-ben");
        } else {
            System.out.println("Vannak effektek");
            List<String> effectsByParams = Arrays.asList(stateData.get("_Effects").toString().split("\n"));
            effectsByParams.forEach(
                  (effectParams) -> {
                      String[] params = effectParams.split("-");
                      System.out.println(Arrays.toString(params));
                      Room room = rooms
                              .stream()
                              .filter(r -> r.getId() == Integer.parseInt(params[1]))
                              .findFirst()
                              .orElse(null);

                      switch (params[0]) {
                          case "Cursed":
                              Effect cursed = new Cursed();
                              effects.add(cursed);
                              room.addEffect(cursed);
                              break;
                          case "Gassy":
                              Effect gassy = new Gassy();
                              effects.add(gassy);
                              room.addEffect(gassy);
                              break;
                          case "Sticky":
                              Effect sticky = new Sticky();
                              effects.add(sticky);
                              room.addEffect(sticky);
                              break;
                          default:
                              System.err.println("Hibás character type: " + params[0]);
                    }
                }
            );
        }

        System.out.println("Itemek felépítése");
        List<String> itemsByParams = Arrays.asList(stateData.get("_Items").toString().split("\n"));
        List<Item> items = new ArrayList<>();
        itemsByParams.forEach(
            (itemParams)-> {
                String[] params = itemParams.split("-");
                System.out.println(Arrays.toString(params));
                Character owner = null;
                Room room = null;
                switch (params[4]) {
                    case "Character":
                        owner = characters
                                .stream()
                                .filter(
                                        o -> o.getId() == Integer.parseInt(params[5])
                                )
                                .findFirst()
                                .orElse(null);
                        break;
                    case "Room":
                        room = rooms
                                .stream()
                                .filter(
                                        r -> r.getId() == Integer.parseInt(params[5])
                                )
                                .findFirst()
                                .orElse(null);
                        break;
                    default:
                        System.err.println("Hibás owner type: " + params[0]);
                }


                //TODO meg kell csinálni mindegyik itemnek a rendes konstruktort a megfelelő paraméterekkel, amit a 8. doksiban megadott teszt fájlokban lévő paraméterekkel meghívunk.
                // Az nem lenne megoldás, hogy a paraméterek számát módósítgatjuk tesztenként. FIX kell hogy legyen a fájlban megadott _Items paraméterek száma
                // én ezt kaptam infónak: type-id-validity-durability-ownertype-ownerid
                // de látom, hogy van, hogy az "owner" a szoba, ami nyilván nem lehet, mert a Roomnak csak az Object a közös ősosztály a Characterrel
                // Szóval kell egy "helyszín" (pl: place) változó az Item-be, és ehhez setter-getter, hogy beállíthassuk.
                // De ha már van valahol ilyen, akkor itt írjátok át. Plusz lehet érdemes lecsekkolni az egyes itemek inicializáláshoz mik kellenek...
                switch (params[0]) {
                    case "Sliderule":
                        Item item = new Sliderule(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "Airfreshener":
                        item = new Airfreshener(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "Beerglass":
                        item = new Beerglass(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "Camembert":
                        item = new Camembert(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "FFP2":
                        item = new FFP2(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "Rag":
                        item = new Rag(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    case "Transistor":
                        item = new Transistor(Integer.parseInt(params[1]), (params[2]).equals("1"), Integer.parseInt(params[3]));
                        if (room == null)
                            item.setOwner(owner);
                        else {
                            System.out.println("Nincs owner, mert le van rakva egy szobában");
                            //item.setPlace(room);
                            room.addItem(item);
                        }
                        items.add(item);
                        break;
                    default:
                        System.err.println("Hibás Item type:" + params[0]);
                }
                //TODO most még üres az items lista, ha meglesz megfelelő konstruktor, és a megfelelő setPlace(), akkor csak ki kell kommentezni
            }
        );

        return new State(rooms, characters, items, effects);
    }

    private List<TestActionDTO> toActionDTOs(List<String> actions, List<Character> characters) {
        List<TestActionDTO> actionDTOs = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i);
            Character character = characters.get(i);
            String[] parts = action.split("-");
            TestActionDTO actionDTO = new TestActionDTO();
            actionDTO.character = character;
            actionDTO.action = parts[0];
            actionDTO.params = new String[parts.length - 1];
            System.arraycopy(parts, 1, actionDTO.params, 0, parts.length - 1);
            actionDTOs.add(actionDTO);
        }
        return actionDTOs;
    }

    private BufferedReader convertToBufferedReader( StringBuilder stringBuilder) {
        StringReader stringReader = new StringReader(stringBuilder.toString());
        return new BufferedReader(stringReader);
    }

    private BufferedReader getFile(String filename) {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("src/testing/valuesfiles/"+filename));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return reader;
    }



    private LinkedHashMap<String, StringBuilder> parseGameData(BufferedReader reader, String splittingString) {
        LinkedHashMap<String, StringBuilder> dataMap = new LinkedHashMap<>();

        try  {
            String line;
            String sectionKey = null;
            StringBuilder sectionContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(splittingString)) {
                    System.out.println("-------------");
                    System.out.println("Found section: " + line);
                    if (sectionKey != null) {
                        dataMap.put(sectionKey, sectionContent);
                        System.out.println("Add previous section: " + sectionKey + " with content: " + sectionContent.toString());
                    } else {
                        System.out.println("No previous section to add");
                    }
                    sectionKey = line.trim();
                    sectionContent = new StringBuilder();
                } else {
                    sectionContent.append(line.trim()).append("\n");
                    System.out.println("-------------");
                    System.out.println("Building section: " + sectionContent);
                }
            }
            // Add the last section
            if (sectionKey != null) {
                dataMap.put(sectionKey, sectionContent);
                System.out.println("Add the last section: " + sectionKey + " with content: " + sectionContent.toString());
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return dataMap;
    }
}
