package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    public ListView<Friend> friendsDisplay = new ListView<>();
    public ArrayList<Friend> friendsBook = new ArrayList<>();
    public ArrayList<String> fileList = new ArrayList<>();
    public ArrayList<Friend> tempBook = new ArrayList<>();
    public TextField friendName;
    public TextField friendAge;
    public Slider kindnessInput;
    public Slider crazinessInput;
    public Slider creativityInput;
    public Button createFriendBtn;
    public Button deleteFriendBtn;
    public Label nameDisplay;
    public Label ageDisplay;
    public Label kindnessDisplay;
    public Label crazinessDisplay;
    public Label creativityDisplay;
    public Friend selectedFriend;
    public Label currentBook;
    public Button changeBookDownBtn;
    public Button changeBookUpBtn;
    public Button addGroupBtn;
    public TextField addGroupName;
    public Label newListStatus;

    //Requires: txt file: Friends Book.txt, txt file: fileList.txt
    //Modifies: this
    //Effects: when program loaded loads friendsBook, friendsDisplay, fileList
    public void initialize() throws IOException {
        loadFileList();
        setFriendsBook(readFriendInfo("Friends Book.txt"));
        setFriendsDisplay(friendsBook);
        if (friendsDisplay.getItems().size() <= 0) {
            friendsDisplay.setDisable(true);
        }
    }

    //Requires: valid selections in textfields
    //Modifies: this, Friends Book.txt
    //Effects: adds friends based on user specification to friendsBook and or tempBook, saves to appropriate txt file
    public void createFriend(ActionEvent actionEvent) throws IOException {
        int age;
        String name;
        try {
            age = Integer.parseInt(friendAge.getText());
        } catch (Exception e) {
            age = 0;
        }
        if (friendName.getText().equals("")) {
            name = " ";
        } else {
            name = friendName.getText();
        }
        Friend yourFriend = new Friend(name, age, (int) Math.round(kindnessInput.getValue()), (int) Math.round(crazinessInput.getValue()), (int) Math.round(creativityInput.getValue()));
        friendsBook.add(yourFriend);
        resetBuildFriend();
        friendsDisplay.setDisable(false);
        if (!currentBook.getText().equals("Friends Book")) {
            tempBook.add(yourFriend);
            setFriendsDisplay(tempBook);
            saveTempBook(currentBook.getText());
        }
        else{
            setFriendsDisplay(friendsBook);
        }
        saveFriendsBook();
    }

    //Requires: friendsDisplay.setDisable = false
    //Modifies: this
    //Effects: sets this.selectedFriend to selected friend, displays attributes, enables deleteBtn
    public void selectFriend(MouseEvent mouseEvent) {
        selectedFriend = (friendsDisplay.getSelectionModel().getSelectedItem());
        nameDisplay.setText(selectedFriend.getName());
        ageDisplay.setText(String.valueOf(selectedFriend.getAge()));
        kindnessDisplay.setText(String.valueOf(selectedFriend.getKindness()));
        crazinessDisplay.setText(String.valueOf(selectedFriend.getCraziness()));
        creativityDisplay.setText(String.valueOf(selectedFriend.getCreativity()));
        deleteFriendBtn.setDisable(false);
    }

    //Requires: a friend is selected
    //Modifies: this, Friends Book.txt
    //Effects: removes friend from friendsBook or tempBook, saves to appropriate files
    public void deleteFriend(ActionEvent actionEvent) throws IOException {
        resetSelectFriend();
        friendsDisplay.getItems().remove(selectedFriend);
        friendsBook.remove(selectedFriend);
        if (!currentBook.getText().equals("Friends Book")) {
            tempBook.remove(selectedFriend);
            saveTempBook(currentBook.getText());
        }
        if (friendsDisplay.getItems().size() <= 0) {
            friendsDisplay.setDisable(true);
        }
        saveFriendsBook();
    }

    //Modifies: this
    //Effects: sets select friends displays to default, disables deleteBtn
    public void resetSelectFriend() {
        nameDisplay.setText("");
        ageDisplay.setText("");
        kindnessDisplay.setText("");
        crazinessDisplay.setText("");
        creativityDisplay.setText("");
        deleteFriendBtn.setDisable(true);
    }

    //Modifies: this
    //Effects: sets build friends entries to default
    public void resetBuildFriend() {
        friendName.clear();
        friendAge.clear();
        kindnessInput.setValue(kindnessInput.getMin());
        crazinessInput.setValue(crazinessInput.getMin());
        creativityInput.setValue(creativityInput.getMin());
    }

    //Modifies: Friends Book.txt
    //Effects: saves friendsBook to Friends Book.txt
    public void saveFriendsBook() throws IOException {
        FileWriter fw = new FileWriter("Friends Book.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        if (friendsBook.size() > 0) {
            for (Friend i : friendsBook) {
                bw.write(i.getTxtString());
            }
        } else {
            bw.write("");
        }
        bw.close();
    }

    //Requires: input txt file exists
    //Modifies: txt.txt
    //Effects: saves tempBook to selected txt file
    public void saveTempBook(String txt) throws IOException {
        FileWriter fw = new FileWriter(txt + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (Friend i : tempBook) {
            bw.write(i.getTxtString());
        }
        bw.close();
    }

    //Requires: more than one file (group)
    //Modifies: this
    //Effects: changes selected file to save to
    public void changeBookDown(ActionEvent actionEvent) throws IOException {
        if (currentBook.getText().equals("Friends Book")) {
        } else if ((currentBook.getText() + ".txt").equals(fileList.get(0))) {
            currentBook.setText("Friends Book");
            friendsBook = readFriendInfo("Friends Book.txt");
            setFriendsDisplay(friendsBook);
            if (friendsDisplay.getItems().size() <= 0) {
                friendsDisplay.setDisable(true);
            } else {
                friendsDisplay.setDisable(false);
            }
        } else {
            int indexCurrentBook = fileList.indexOf(currentBook.getText() + ".txt");
            currentBook.setText(fileList.get(indexCurrentBook - 1).substring(0, fileList.get(indexCurrentBook - 1).length() - 4));
            tempBook = readFriendInfo(currentBook.getText() + ".txt");
            setFriendsDisplay(tempBook);
            if (friendsDisplay.getItems().size() <= 0) {
                friendsDisplay.setDisable(true);
            } else {
                friendsDisplay.setDisable(false);
            }
        }
    }

    //Requires: more than one file (group)
    //Modifies: this
    //Effects: changes selected file to save to
    public void changeBookUp(ActionEvent actionEvent) throws IOException {
        if (currentBook.getText().equals("Friends Book") && fileList.size() <= 0) {
        } else if (currentBook.getText().equals("Friends Book")) {
            currentBook.setText(fileList.get(0).substring(0, fileList.get(0).length() - 4));
            tempBook = readFriendInfo(currentBook.getText() + ".txt");
            setFriendsDisplay(tempBook);
            if (friendsDisplay.getItems().size() <= 0) {
                friendsDisplay.setDisable(true);
            } else {
                friendsDisplay.setDisable(false);
            }
        } else if ((currentBook.getText() + ".txt").equals(fileList.get(fileList.size() - 1))) {
        } else {
            int indexCurrentBook = fileList.indexOf(currentBook.getText() + ".txt");
            currentBook.setText((fileList.get(indexCurrentBook + 1)).substring(0, (fileList.get(indexCurrentBook + 1).length() - 4)));
            tempBook = readFriendInfo(currentBook.getText() + ".txt");
            setFriendsDisplay(tempBook);
            if (friendsDisplay.getItems().size() <= 0) {
                friendsDisplay.setDisable(true);
            } else {
                friendsDisplay.setDisable(false);
            }
        }
    }

    //Requires: addGroupName.getText()!= ""
    //Modifies: this
    //Effects: adds a file (group) to save to based on user input
    public void addGroup(ActionEvent actionEvent) throws IOException {
        String fileName = addGroupName.getText() + ".txt";
        if (!addGroupName.getText().equals("") && (!addGroupName.getText().equals("friendsBook") && !addGroupName.getText().equals("Friends Book"))) {
            try {
                File myObj = new File(fileName);
                if (myObj.createNewFile()) {
                    newListStatus.setText("Successful");
                    fileList.add(addGroupName.getText() + ".txt");
                } else {
                    newListStatus.setText("Already exists");
                }
            } catch (IOException e) {
            }
            FileWriter fw = new FileWriter("fileList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String i : fileList) {
                bw.write(i + "\r");
            }
            bw.close();
        }
    }

    //Modifies: this
    //Effects: sets listView friendsDisplay to ArrayList
    public void setFriendsDisplay(ArrayList<Friend> input) {
        if (input != null) {
            friendsDisplay.setDisable(false);
            friendsDisplay.getItems().clear();
            for (Friend i : input) {
                friendsDisplay.getItems().add(i);
            }
        }
    }

    //Modifies: this
    //Effects: makes setting ArrayList friendsBook to ArrayList easier
    public void setFriendsBook(ArrayList<Friend> friendsBook) {
        this.friendsBook = friendsBook;
    }

    //Requires: valid txt file to read
    //Effects: parses friend info from txt file and returns loaded friends in an ArrayList
    public ArrayList<Friend> readFriendInfo(String txt) throws IOException {
        ArrayList<Friend> loadedFriends = new ArrayList<>();
        FileReader fr = new FileReader(txt);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String name;
        int age;
        int kindness;
        int craziness;
        int creativity;
        while ((line = br.readLine()) != null) {
            name = line.substring(6, line.indexOf("&$/2$&"));
            age = Integer.parseInt(line.substring(line.indexOf("&$/2$&") + 6, line.indexOf("&$/3$&")));
            kindness = Integer.parseInt(line.substring(line.indexOf("&$/3$&") + 6, line.indexOf("&$/4$&")));
            craziness = Integer.parseInt(line.substring(line.indexOf("&$/4$&") + 6, line.indexOf("&$/5$&")));
            creativity = Integer.parseInt(line.substring(line.indexOf("&$/5$&") + 6, line.indexOf("&$/6$&")));
            loadedFriends.add(new Friend(name, age, kindness, craziness, creativity));
        }
        br.close();
        return loadedFriends;
    }

    //Requires: fileList.txt
    //Modifies: this
    //Effects: sets this.fileList to files listed in fileList.txt
    public void loadFileList() throws IOException {
        ArrayList<String> output = new ArrayList();
        FileReader fr = new FileReader("fileList.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals("")) {
                output.add(line);
            }
        }
        br.close();
        fileList = output;
    }
}