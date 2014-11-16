class linkedList 
{
	private node headOfList;
	

	linkedList() 
	{
		headOfList = null;
	}
	

	void addElem(node newNode)
	{
		//if list is empty then add it as the head
		
				if (headOfList == null)
				{
					headOfList = newNode;
				} else { //else iterate through the list till we reach the end
					node curNode = headOfList;
					while(curNode.getNextNode() != null)
					{	
						curNode = curNode.getNextNode();
					}
					// then add the node at the end
					curNode.setNextNode(newNode);
				}
	}
	
	// overloaded version for adding integers directly
	void addElem(int newVal)
	{
		addElem(new node(newVal));
	}
	
	
	void removeElem(int toRemove)
	{
		if (headOfList != null) // cannot remove from empty list
		{
			node curNode = headOfList;
			
			// special case for if the head of the list is to be removed
			
			if (curNode.getVal() == toRemove)
			{
				headOfList = headOfList.getNextNode();
			} else {
				// iterates through the list, till the end or the value is found
				while (curNode.getNextNode() != null)
				{
					// "looks ahead" for the value to be removed
					int nextNodeVal = (curNode.getNextNode()).getVal();
					if(nextNodeVal == toRemove)
					{
						// gets the rest of the list without the value to be removed
						node cleanedList = (curNode.getNextNode()).getNextNode();
						// sets it to the next node of the current list, skipping the offending element 
						curNode.setNextNode(cleanedList);
						return;
					}
					curNode = curNode.getNextNode();
				}
			}
		}
	}
	
	node getHead()
	{
		return headOfList;
	}
	
	node getNthElem(int n) 
	{
		node nthNode = null;
		// we require n to be >= 0
		assert (n >= 0);
		// assuming n = 0 means the head
		if(n == 0)
		{
			nthNode = headOfList;
		} else {
			// iterate through the list
			node curNode = headOfList;
			while(curNode.getNextNode() != null)
			{
				curNode = curNode.getNextNode();
				// decrement n to act as a countdown to the correct element
				n -= 1;
				if(n == 0) 
				{
					nthNode = curNode;
					break;
				}
			}
		}
		
		// will return nthNode or null if n > listLength 
		return nthNode;
	}
	
	// another version of getNth for returning integers
	int getNthElemInt(int n)
	{
		return getNthElem(n).getVal();
	}
	
	int length()
	{
		// iterates through the list
		int len = 0;
		if(headOfList != null)
		{
			len += 1;
			node curNode = headOfList;
			while(curNode.getNextNode() != null)
			{
				// increments a counter len
				curNode = curNode.getNextNode();
				len += 1;
			}
		}
		// returns counter
		return len;
	}
	
	// returns true if a value exists in the linked list
	boolean elemExists(int value)
	{
		// assumes it does not exist
		boolean found = false;
		if (headOfList != null)
		{
			node curNode = headOfList;
			while(curNode != null)
			{
				// if found then it breaks and returns true
				if(curNode.getVal() == value)
				{
					found = true;
					break;
				}
				curNode = curNode.getNextNode();
			}
		} 
		return found;
	}
	
	boolean cycleExists()
	{
		// the hashcode is a integer which uniquely identifies objects, in this case nodes
		// we compute a linked list of these hash codes and upon the addition of each element
		// we check if it previously existed in the list
		// if so then there is a cycle in the list
		boolean cycleFound = false;
		linkedList hashCodeList = new linkedList();
		node curNode = headOfList;
		while(curNode != null)
		{
			// elemExists is O(n), we call it n times so this algorithm is O(n^2)
			// hash functions usually are O(1), so we don't need to worry about that
			int hashVal = curNode.hashCode();
			if(hashCodeList.elemExists(hashVal))
			{
				cycleFound = true;
				break;
			} else {
				hashCodeList.addElem(hashVal);
				curNode = curNode.getNextNode();
			}
		}
		
		return cycleFound;
	}
}

class node 
{
	private int value;
	private node nextNode;
	
	//constructor
	
	node(int newVal)
	{
		value = newVal;
		nextNode = null;
	}
	
	//private state, so we need get and set methods
	
	int getVal()
	{
		return value;
	}
	
	void setVal(int newVal)
	{
		value = newVal;
	}
	
	node getNextNode()
	{
		return nextNode;
	}
	
	void setNextNode(node newNext)
	{
		nextNode = newNext;
	}
}

public class Question7and8 {

}
