package code;

import java.util.HashMap;

public class Assignment {

	
	 public int capacity;
	    HashMap<String, Node> map;
	    DoublyLinkedList list;

	    public Assignment(int capacity) {
	    this.capacity = capacity;
	    map = new HashMap<>();
	    list = new DoublyLinkedList();
	    }

	    public void addSong(String song, String user) {
	    if (map.containsKey(song)) {
	    Node node = map.get(song);
	    list.moveToFront(node);
	    } else {
	    if (map.size() >= capacity) {
	    Node lastNode = list.removeLast();
	    map.remove(lastNode.song);
	            }
	    
	    Node newNode = new Node(song, user);
	    map.put(song, newNode);
	    list.addToFront(newNode);
	        }
	    }

	    public void displayRecentlyPlayed(String user) {
	    System.out.println("Total Song Played By-" + user + ":");
	    Node node = list.head;
	    while (node != null) {
	    if (node.user.equals(user)) {
	    System.out.println(node.song);
	            }
	    
	    node = node.next;
	        }
	    
	    System.out.println();
	    }

	    private class DoublyLinkedList {
	    Node head;
	    Node tail;

	   private void addToFront(Node node) {
	   if (head == null) {
	   head = node;
	   tail = node;
	   } else {
	   node.next = head;
	   head.prev = node;
	   head = node;
	            }
	        }

	 private void moveToFront(Node node) {
	 if (node == head) {
	 return;
	            }

	if (node == tail) {
	tail = tail.prev;
	tail.next = null;
	} else {
	node.prev.next = node.next;
	node.next.prev = node.prev;
	            }

node.prev = null;
	node.next = head;
	head.prev = node;
	head = node;
	        }

private Node removeLast() {
	if (tail == null) {
	return null;
	            }

Node lastNode = tail;

if (tail == head) {
	head = null;
tail = null;
	} else {
	tail = tail.prev;
	tail.next = null;
	            }

return lastNode;
	        }
	    }

public class Node {
	String song;
	String user;
	Node prev;
	Node next;

	Node(String song, String user) {
	this.song = song;
	this.user = user;
	        }
	    }

	public static void main(String[] args) {
	Assignment store = new Assignment(3);

	store.addSong("S1", "User1");
	store.addSong("S2", "User1");
	store.addSong("S3", "User1");
	store.displayRecentlyPlayed("User1");
      
	System.out.println("When S4 Song Is Played");
	store.addSong("S4", "User1");
	store.displayRecentlyPlayed("User1");
      
	System.out.println("When S2 Song Is Played");
	store.addSong("S2", "User1");
	store.displayRecentlyPlayed("User1");
      
	System.out.println("When S1 Song Is Played");
	store.addSong("S1", "User1");
	store.displayRecentlyPlayed("User1");
	    }
	}
