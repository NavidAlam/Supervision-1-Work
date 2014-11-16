
public class Question10 {
	class stack
	{
		// data encapsulation
		private node top;
		
		// constructor
		stack()
		{
			top = null;
		}
		
		// overloaded constructors
		stack(node top)
		{
			this.top = top;
		}
		
		stack(int topVal)
		{
			top = new node(topVal);
		}
		
		int pop()
		{
			// making sure the stack is not empty
			assert (top != null);
			int topVal = top.getVal();
			top = top.getNextNode();
			return topVal;
		}
		
		boolean isEmpty()
		{
			return (top == null);
		}
		
		// same as pop() but returns result as a node
		node popN()
		{
			return new node(pop());
		}
		
		void push(node newTop)
		{
			newTop.setNextNode(top);
			top = newTop;
		}
		
		// overloaded push
		void push(int newTopVal)
		{
			push(new node(newTopVal));
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
