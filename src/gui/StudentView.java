package src.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.character.Character;
import src.dto.ChangeType;
import src.effect.Cursed;
import src.effect.Effect;
import src.effect.Gassy;
import src.effect.Sticky;
import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

import java.util.ArrayList;
import java.util.List;

public class StudentView extends JPanel implements ModelObserver{
    public Character character;
    public RoomView room;
    public List<ItemView> inventory;
    private List<JButton> actionButtons;

    GridBagConstraints roomViewgbc = new GridBagConstraints();

    public StudentView(Character c) { //ez a jatekos viewja, minden jatekos viewja egy uj tabon
        inventory = new ArrayList<ItemView>();
        actionButtons = new ArrayList<JButton>();
        character = c;

        for (Item i : character.getInventory()) { //ItemView-ok lekérése character inventoryjából
            inventory.add(i.getView());
        }

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel 1: random kép Panel in row=0, col=0
        RoomView room = new RoomView(character.getCurrentRoom()); //igazabol a current room roomview-ja

        room.setPreferredSize(new Dimension(300, 300));
        room.setMinimumSize(new Dimension(300, 300));
        gbc.gridx = 0; //a gridben hanyadik oszlop
        gbc.gridy = 0; //a gridben hanyadik sor
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 3;  //oszlop relativ szelesseg
        gbc.weighty = 3; //sor relativ szelesseg
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around the panel
        add(room, gbc);
        //setRoomView(currentRoom);

        // Panel 2: szomszédok
        JPanel listPanel1 = createNeighboursPanel();

        JScrollPane scrollPane1 = new JScrollPane(listPanel1);
        scrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane1.setPreferredSize(new Dimension(200, 300));
        scrollPane1.setMinimumSize(new Dimension(200, 300));
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10); //margin
        add(scrollPane1, gbc);

        // Panel 3: inventory
        JPanel listPanel2 = createInventoryPanel();

        JScrollPane scrollPane2 = new JScrollPane(listPanel2);
        scrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane2.setPreferredSize(new Dimension(200, 300));
        scrollPane2.setMinimumSize(new Dimension(200, 300));
        gbc.gridx = 2;
        gbc.insets = new Insets(10, 10, 10, 10);  // Adjust padding
        add(scrollPane2, gbc);

        // Panel 4: szoba tulajdonságai
        JPanel RoomAttributePanel = createRoomAttribPanel();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        add(RoomAttributePanel, gbc);

        // Panel 5: Button Panel in row=1 spanning the last 2 columns
        JPanel buttonPanel = new JPanel(new FlowLayout());

        //move button
        JButton moveButton = createMoveButton();
        buttonPanel.add(moveButton);
        actionButtons.add(moveButton);

        //pick up gomb
        JButton pickupButton = createPickUpButton();
        buttonPanel.add(pickupButton);
        actionButtons.add(pickupButton);

        //drop button
        JButton dropButton = createDropButton();
        buttonPanel.add(dropButton);
        actionButtons.add(dropButton);

        //use button
        JButton useButton = createUseButton();
        buttonPanel.add(useButton);
        actionButtons.add(useButton);

        //skip button
        JButton skipButton = createSkipButton();
        buttonPanel.add(skipButton); //skip button add
        actionButtons.add(skipButton);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;  // Span across all columns
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.2;  // Adjust weight for the button panel
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around the panel
        add(buttonPanel, gbc);
    }

    public String toString() {
        return character.toString() + character.getId();
    }

    @Override
    public void update(Room room, ChangeType type) {
        return;
    }

    @Override
    public void update(Character character, ChangeType type) {
        return;
    }

    @Override
    public void update(Item item, ChangeType type) {
        ItemView iv = GUIController.getItemViews().stream().filter(i -> i.item == item).findFirst().orElse(null);
        if (iv == null)
            return;
        if (type == ChangeType.ADD) {
            addItemView(iv);
        } else if (type == ChangeType.REMOVE) {
            removeItemView(iv);
        }
    }

    @Override
    public void update(Effect effect, ChangeType type) {
        return;
    }

    @Override
    public void update() {
        //Gombok letiltása
        if (GameLogic.getCurrentPlayer() == character) {
            for (JButton b : actionButtons) {
                b.setEnabled(true);
            }
        } else {
            for (JButton b : actionButtons) {
                b.setEnabled(false);
            }
        }
    }

    private void removeItemView(ItemView iv) {
        inventory.remove(iv);
    }

    private void addItemView(ItemView iv) {
        inventory.add(iv);
    }

    public JPanel createNeighboursPanel() {
        JPanel listPanel1 = new JPanel();
        listPanel1.setLayout(new BoxLayout(listPanel1, BoxLayout.Y_AXIS));

        JLabel neighboursTitle = new JLabel(character.getCurrentRoom().toString() + "'s Neighbours");
        neighboursTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        neighboursTitle.setAlignmentY(Component.CENTER_ALIGNMENT);
        listPanel1.add(neighboursTitle);

        for (Room r : character.getCurrentRoom().getNeighbours()) {
            JPanel smallPanel = new JPanel();
            smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
            smallPanel.setMaximumSize(new Dimension(1000, 75));
            smallPanel.setBackground(new Color(156, 156, 156));

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
            infoPanel.setOpaque(false);
            infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            infoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
            infoPanel.add(Box.createHorizontalGlue());

            for (Effect e : r.getEffects()) {
                JLabel effectIconLabel = new JLabel();
                ImageIcon imageIcon = e.getIcon();
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                effectIconLabel.setIcon(imageIcon);
                effectIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                effectIconLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
                infoPanel.add(effectIconLabel);
                infoPanel.add(Box.createRigidArea(new Dimension(10, 0)));
                smallPanel.setBackground(new Color(186, 0, 0));
            }
            JLabel label = new JLabel(r.toString());
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setAlignmentY(Component.CENTER_ALIGNMENT);
            infoPanel.add(label);
            infoPanel.add(Box.createHorizontalGlue());
            smallPanel.add(infoPanel);
            listPanel1.add(smallPanel);

            JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
            separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 4));
            listPanel1.add(separator);
        }
        return listPanel1;
    }

    public JPanel createInventoryPanel() {
        JPanel listPanel2 = new JPanel();
        listPanel2.setLayout(new BoxLayout(listPanel2, BoxLayout.Y_AXIS));

        JLabel inventoryTitle = new JLabel(character.toString() + character.getId() + "'s Inventory");
        inventoryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryTitle.setAlignmentY(Component.CENTER_ALIGNMENT);
        listPanel2.add(inventoryTitle);

        for (ItemView item : inventory) {
            JPanel smallPanel = new JPanel();
            smallPanel.setMaximumSize(new Dimension(1000, 75));
            smallPanel.setBackground(item.getColor());

            JLabel label = new JLabel(item.getIcon());
            label.setText(item.toString());
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setVerticalTextPosition(JLabel.CENTER);
            smallPanel.add(label);

            listPanel2.add(smallPanel);

            JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
            separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 4));
            listPanel2.add(separator);
        }
        return listPanel2;
    }

    public JPanel createRoomAttribPanel() {
        JPanel RoomAttributePanel = new JPanel();
        RoomAttributePanel.setLayout(new BoxLayout(RoomAttributePanel, BoxLayout.Y_AXIS));
        RoomAttributePanel.setPreferredSize(new Dimension(100, 95));
        RoomAttributePanel.setMinimumSize(new Dimension(100, 95));
        
        JLabel szobanevlabel = new JLabel("Current room: " + character.getCurrentRoom().toString());
        szobanevlabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        szobanevlabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        RoomAttributePanel.add(szobanevlabel);

        JLabel szobacapacitylabel = new JLabel("Capacity: " + character.getCurrentRoom().getCapacity());
        szobacapacitylabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        szobacapacitylabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        RoomAttributePanel.add(szobacapacitylabel);

        JLabel effectsLabel = new JLabel("Effects: ");
        effectsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        effectsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        RoomAttributePanel.add(effectsLabel);

        JPanel effectIconPanel = new JPanel();
        effectIconPanel.setLayout(new BoxLayout(effectIconPanel, BoxLayout.X_AXIS));
        effectIconPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        if (character.getCurrentRoom().getEffects().size() == 0) {
            ImageIcon imageIcon = new ImageIcon("images/None.png");
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            JLabel effectLabel = new JLabel(imageIcon);
            effectIconPanel.add(effectLabel);
        }
        for (Effect e : character.getCurrentRoom().getEffects()) {
            ImageIcon imageIcon = e.getIcon();
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            JLabel effectLabel = new JLabel(imageIcon);
            effectIconPanel.add(effectLabel);
        }
        RoomAttributePanel.add(effectIconPanel);
        return RoomAttributePanel;
    }

    public JButton createMoveButton() {
        JButton moveButton = new JButton("Move"); //move gomb
        ArrayList<Room> roomOptions = character.getCurrentRoom().getNeighbours();
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (roomOptions.size() != 0) {
                    JPopupMenu roomMenu = new JPopupMenu();
                    for (int j = 0; j < roomOptions.size(); j++) {
                        Room room = roomOptions.get(j);
                        JMenuItem menuItem = new JMenuItem(room.toString());
                        final int index = j;
                        menuItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                character.move(index);
                                GUIController.setAction();
                                System.out.println(character.getCurrentRoom().toString());
                            }
                        });
                        roomMenu.add(menuItem);
                    }
                    roomMenu.show(moveButton, moveButton.getWidth() / 2, moveButton.getHeight() / 2);
                }
            }
        });
        return moveButton;
    }

    public JButton createPickUpButton() {
        JButton pickupButton = new JButton("Pick Up Item");
        ArrayList<Item> itemOptions = character.getCurrentRoom().getItems();
        pickupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itemOptions.size() != 0) {
                    JPopupMenu itemMenu = new JPopupMenu();
                    for (int j = 0; j < itemOptions.size(); j++) {
                        Item item = itemOptions.get(j);
                        JMenuItem menuItem = new JMenuItem(item.toString());
                        final int index = j;
                        menuItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                character.pickUpItem(index);
                                GUIController.setAction();
                            }
                        });
                        itemMenu.add(menuItem);
                    }
                    itemMenu.show(pickupButton, pickupButton.getWidth() / 2, pickupButton.getHeight() / 2);
                }
            }
        });
        return pickupButton;
    }

    public JButton createDropButton() {
        JButton dropButton = new JButton("Drop Item");
        ArrayList<Item> dropOptions = character.getInventory();
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dropOptions.size() != 0) {
                    JPopupMenu dropMenu = new JPopupMenu();
                    for (int j = 0; j < dropOptions.size(); j++) {
                        Item item = dropOptions.get(j);
                        JMenuItem menuItem = new JMenuItem(item.toString());
                        final int index = j;
                        menuItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                character.dropItem(index);
                                GUIController.setAction();
                            }
                        });
                        dropMenu.add(menuItem);
                    }
                    dropMenu.show(dropButton, dropButton.getWidth() / 2, dropButton.getHeight() / 2);
                }
            }
        });
        return dropButton;
    }

    public JButton createUseButton() {
        JButton useButton = new JButton("Use Item");
        ArrayList<Item> useOptions = character.getInventory();
        useButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (useOptions.size() != 0) {
                    JPopupMenu useMenu = new JPopupMenu();
                    for (int j = 0; j < useOptions.size(); j++) {
                        Item item = useOptions.get(j);
                        JMenuItem menuItem = new JMenuItem(item.toString());
                        final int index = j;
                        menuItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                character.useItem(index);
                                GUIController.setAction();
                            }
                        });
                        useMenu.add(menuItem);
                    }
                    useMenu.show(useButton, useButton.getWidth() / 2, useButton.getHeight() / 2);
                }
            }
        });
        return useButton;
    }

    public JButton createSkipButton() {
        JButton skipButton = new JButton("Skip Turn");
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                character.skipTurn();
                GUIController.setAction();
                System.out.println("Skipped turn");
            }
        });
        return skipButton;
    }

    public void updateRoomView(RoomView newRoomView) {
    }
}
