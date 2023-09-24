package LinkedList;


class PlayList {

    Node headNode;  // This node will linked to the end

    public static void main(String[] args) {

        PlayList playListRock  = new PlayList();
        String theBeatles = "The Beatles";
        Song song  = new Song("She loves you", theBeatles );
        Song song1 = new Song("Yesterday",theBeatles);
        Song song2 = new Song("Help",theBeatles );
        Song song3 = new Song("Paint it, black","The rolling stones");

        playListRock.addSong(song);
        playListRock.addSong(song1);
        playListRock.addSong(song2);
        playListRock.addSong(song3);

        System.out.println(" ---------------------------------");
        System.out.println(" Full playlist display");
        playListRock.displayPlayList();

        // Problem1,   I want to delete the Songs Help.. from the Beatles
        //  Node(She loves you) -> Node(Yesterday) -> Node(Help) -> Node(Paint it black)
        // The PlayList will remain  She loves you, Yesterday, Paint it, Black
        System.out.println(" ---------------------------------");
        System.out.println(" Full playlist display after remove a song");
        playListRock.removeSong(song2);
        playListRock.displayPlayList();


        // Problem 2: I want to merge 2 Playlist together
        PlayList playListAdele = new PlayList();
        String adele = "Adele";
        Song song4  = new Song("Rolling in the deep", adele );
        Song song5 = new Song("Someone like you",adele);
        Song song6 = new Song("I Drink Wine",adele );
        Song song7 = new Song("When we were young",adele);

        playListAdele.addSong(song4);
        playListAdele.addSong(song5);
        playListAdele.addSong(song6);
        playListAdele.addSong(song7);

        System.out.println(" ---------------------------------");
        System.out.println(" Full playlist display after MERGE");
        PlayList mergePlayList =  playListRock.mergeTwoList(playListRock ,playListAdele);
        mergePlayList.displayPlayList();


    }

    private PlayList mergeTwoList(PlayList playList1, PlayList playList2) {
        // Given a new merged playList
       PlayList mergedPlayList =  new PlayList();

       // create headNode
        mergedPlayList.headNode = playList1.headNode;  // Node 1 2 3 4

        // Go to the end of the linkedlist
        Node lastNode = headNode;
        while (lastNode.nextNode != null) {
            lastNode = lastNode.nextNode;
        }

        // Lastnode.nextNode = node 4 5 6 7
        lastNode.nextNode = playList2.headNode;

        return mergedPlayList;
    }

    private  void removeSong(Song song2) {
        // Find the position of the songs
        Node currentNode = headNode;
        Node preNode  = null;
        while (!currentNode.song.equals(song2)) {
            preNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        // Identify Node(Yesterday).nextNode = Node(Paint it, Black)
        preNode.nextNode = currentNode.nextNode;

    }

    private void addSong(Song song) {
        Node newNode = new Node(song);
        if(headNode == null) {
            headNode = newNode;
        } else {
            //  1. The state of CurrentNode is changing, but first, it is the headNode
            Node currentNode = headNode;

            // 2 Traverse linkedlist by update currentNode = a next node.
            while( currentNode.nextNode != null ){
                currentNode = currentNode.nextNode;
            }

            // 3 End of the Linkedlist,
            currentNode.nextNode = newNode;


            // Node head She loves you
            // node 1    Yesterday
            // Want to add new node("Help")... go the node 1 - yesterday ... nextNode = newNode;
        }
    }

    private void displayPlayList() {
        Node currentNode  = headNode;
        while (currentNode.nextNode != null){
            System.out.println(currentNode.song.toString());
            currentNode = currentNode.nextNode;
        }
        System.out.println(currentNode.song.toString());

    }



    public class Node {
        Song song;
        Node nextNode;

        public Node(Song song) {
            this.song = song;
            this.nextNode = null;
        }
    }

    public static class Song {
        private String name;
        private String author;

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }

        public Song(String name, String author) {
            this.name = name;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }
}

/*
I design spotify music playlist

 */