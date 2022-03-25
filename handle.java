import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class handle extends Node {
    private static Node head;
    private static Snode head1;

    
    int money;
    public handle(String name, String username, int pin, long number, String address,long CNIC,String transaction,String FilePath) throws IOException {
        super(name, username, pin, number, address,CNIC,transaction);
    
        Node temp = head;
        Snode temp1 = head1;
        
        this.money=0;
        // try {
        BufferedWriter buffer = new BufferedWriter(new FileWriter(FilePath + this.getUsername() + ".txt",true));
        // FileWriter writer = new FileWriter(FilePath +this.getUsername()+".txt",true);
        // PrintWriter buffer = new PrintWriter(writer);
        while(temp!=null){  
            buffer.write(this.money +"\r\n"+ temp.getName() +"\r\n"+ temp.getUsername()   +"\r\n"+ temp.getPin()  +"\r\n"+ temp.getNumber()  +"\r\n"+ temp.getAddress()+"\r\n"+ temp.getCNIC()+"\r\n"+ "TRANSACTION:0");
            buffer.write("\n");
            temp = temp.next;
            while(temp1!=null){
                buffer.write(temp1.val);
                buffer.write("\n");
                temp1 = temp1.next;
    
            }
            
        }
        System.out.println("\t\t\t\t\tUser-Generated Successfully");
        
        buffer.close();
    } catch (Exception e) {
        System.out.println("Unable to write in a file");
    }

}
    public static void insert(String name, String username,int pinNo, Long numb, String addres,long cnic,String Transaction){
        // Node node = new Node(name, username, pinNo, numb, addres);
        
        if(head==null) {
			
			Node newNode= new Node(name, username, pinNo, numb, addres,cnic,Transaction);
			
			head=newNode;
			newNode.next = null;
			return;
		}
		
		Node currNode=head;
		while(currNode.next!=null) {
			currNode=currNode.next;
			
		}
		
		Node newNode= new Node(name, username, pinNo, numb, addres,cnic,Transaction);
		
		currNode.next=newNode;
        
    }
        
    public static void delete() {
        head=null;
    }


    void message(){
        System.out.println("User-Generated Successfully");
    }
    

}
 

