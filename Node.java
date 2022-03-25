
public class Node {
    private String Name;
    private String Username;
    private int pin;
    private long Number;
    private String Address;
    private long CNIC;
    protected Node next;

    
    public Node(String name, String username, int pin, Long number, String address, long cNIC, String transaction) {
        Name = name;
        Username = username;
        this.pin = pin;
        Number = number;
        Address = address;
        CNIC = cNIC;
    }
    public Node(String name, String username, int pin, long number, String address, long cNIC, Node next) {
        Name = name;
        Username = username;
        this.pin = pin;
        Number = number;
        Address = address;
        CNIC = cNIC;
        this.next = next;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public long getNumber() {
        return Number;
    }
    public void setNumber(long number) {
        Number = number;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public long getCNIC() {
        return CNIC;
    }
    public void setCNIC(long cNIC) {
        CNIC = cNIC;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

}
	
 