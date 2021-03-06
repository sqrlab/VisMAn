import static org.junit.Assert.*;

import java.util.Iterator;

import hashset.HashSet;
import linkedlist.LinkedList;
import linkedlist.ListIterator;
import stack.LinkedListStack;

import org.junit.Test;



public class structureTests 
{
	//Linked List Tests
	@Test
	public void linkedListTest1()
	{
		LinkedList list = new LinkedList();
		ListIterator iterator = list.listIterator();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		assertEquals("A",iterator.next());
	}
	
	@Test
	public void linkedListTest2()
	{
		LinkedList list = new LinkedList();
		ListIterator iterator = list.listIterator();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		iterator.next();
		iterator.set("D");
		assertEquals("D",iterator.previous());
	}
	
	@Test
	public void linkedListTest3()
	{
		LinkedList list = new LinkedList();
		ListIterator iterator = list.listIterator();
		list.addLast("B");
		list.addLast("C");
		iterator.next();
		assertEquals("C", iterator.next());
	}
	
	@Test
	public void linkedListTest4()
	{
		LinkedList list = new LinkedList();
		ListIterator iterator = list.listIterator();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		iterator.next();
		iterator.next();
		assertEquals(true,iterator.hasNext());
	}
	
	@Test
	public void linkedListTest5()
	{
		LinkedList list = new LinkedList();
		list.addFirst("A");
		list.addFirst("B");
		assertEquals("B",list.getFirst());
	}
	
	@Test
	public void linkedListTest6()
	{
		LinkedList list = new LinkedList();
		ListIterator iterator = list.listIterator();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		iterator.next();
		iterator.next();
		iterator.next();
		assertEquals(false,iterator.hasNext());
	}
	
	@Test
	public void linkedListTest7()
	{
		LinkedList list = new LinkedList();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		assertEquals("C", list.getLast());
	}
	
	//Linked List Stack
	
	@Test
	public void stackTest1()
	{
		LinkedListStack stack = new LinkedListStack();
		stack.push("Test");
		stack.push("Test2");
		assertEquals("Test2",stack.pop());
	}
	
	@Test
	public void stackTest2()
	{
		LinkedListStack stack = new LinkedListStack();
		stack.push("Test");
		stack.push("Test2");
		stack.pop();
		assertEquals("Test", stack.pop());
	}
	
	@Test
	public void stackTest3()
	{
		LinkedListStack stack = new LinkedListStack();
		assertEquals(true, stack.empty());
	}
	
	@Test
	public void stackTest4()
	{
		LinkedListStack stack = new LinkedListStack();
		stack.push("Test");
		assertEquals(false, stack.empty());
	}
	
	//HashSet Tests
	
	@Test
	public void hashTest1()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("David");
		assertEquals(true,hashSet.contains("David"));
	}
	
	@Test
	public void hashTest2()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("NotDavid");
		assertEquals(false,hashSet.contains("David"));
	}
	
	@Test
	public void hashTest3()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("David");
		hashSet.remove("David");
		assertEquals(false, hashSet.contains("David"));
	}
	
	@Test 
	public void hashTest4()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("David");
		hashSet.add("NotDavid");
		assertEquals(2,hashSet.size());
	}
	
	@Test 
	public void hashTest5()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("David");
		hashSet.add("NotDavid");
		hashSet.add("Name3");
		hashSet.remove("NotDavid");
		assertEquals(2,hashSet.size());
	}
	
	@Test
	public void hashTest6()
	{
		HashSet hashSet = new HashSet(51);
		hashSet.add("David");
		hashSet.add("NotDavid");
		hashSet.add("Name3");
		Iterator iterator = hashSet.iterator();
		assertEquals(true,iterator.hasNext());
	}
	
	@Test
	public void hashTest7()
	{
		HashSet hashSet = new HashSet(51);
		Iterator iterator = hashSet.iterator();
		assertEquals(false,iterator.hasNext());
	}

}
