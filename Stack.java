
public class Stack{   
    static Snode head;
    Snode tail;
	static int size;
	

	
	public  void Push(int value) {
		Snode hell = new Snode(value);
		hell.next = head;
		head = hell;
		size++;
	}
	
	public static int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is empty you cannot pop in empty stack!");
		}
		
		int result = head.val;
		head = head.next;
		size--;
		return result;
	}
	
	public int top() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is empty you cannot pop in empty stack!");
		}
		
		return head.val;
	}
	public void display()
	{
		Snode temp = head;
		
		while(temp!=null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.print("END");
		
	}
	
    public static boolean isEmpty() {
  	  return size == 0;
    }
}
