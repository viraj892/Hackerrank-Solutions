package QueueUsingStacks;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingStacks {
	public static class MyQueue<T> {
		Stack<T> stack1 = new Stack<T>();
		Stack<T> stack2 = new Stack<T>();

		public void enqueue(T value) { // Push onto newest stack
			if (stack1.empty() && stack2.empty())
				stack2.push(value);
			else
				stack1.push(value);
		}

		public T peek() {
			if (stack1.empty() && stack2.empty())
				return null;
			else if (!stack2.empty())
				return stack2.peek();
			else {
				while (!stack1.empty())
					stack2.push(stack1.pop());
				return stack2.peek();
			}
		}

		public T dequeue() {
			if (stack1.empty() && stack2.empty())
				return null;
			else if (!stack2.empty())
				return stack2.pop();
			else {
				while (!stack1.empty())
					stack2.push(stack1.pop());
				return stack2.pop();
			}
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
