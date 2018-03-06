import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada

public class LinkedListMauricio {

	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			next = null;
			this.data = data;
		}

	}

	private Node first;
	private int size;

	public LinkedListMauricio() {
		size = 0;
		first = null;
	}

	/**
	 * Returns the node at the specified position in this list.
	 * 
	 * @param index
	 *            - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            - index of the element to return
	 * @return the element at the specified position in this list
	 */
	public int get(int index) {
		Node temp = null;
		try {
			temp = getNode(index);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return temp.data;
	}

	// Retorna el tamaño actual de la lista
	public int size() {
		return this.size;
	}

	// Inserta un dato en la posición index
	public void insert(int data, int index) {
		Node nuevo = new Node(data);
		if (index == 0) {
			nuevo.next = first;
			first = nuevo;
		} else {
			Node temp = this.getNode(index - 1);
			nuevo.next = temp.next;
			temp.next = nuevo;
		}
		size++;
	}

	// Borra el dato en la posición index
	public void remove(int index) {
		if (index == 0)
			first = this.getNode(index + 1);
		else {
			Node temp = this.getNode(index - 1);
			temp.next = this.getNode(index).next;
		}
		size--;
	}

	// Verifica si está un dato en la lista
	public boolean contains(int data) {
		Node actual = first;
		while (actual != null) {
			if (actual.data == data)
				return true;
			actual = actual.next;
		}
		return false;
	}

	
	public static void main(String[] args) {
		LinkedListMauricio lista = new LinkedListMauricio();
		lista.insert(3, 0);
		lista.insert(5, 1);
		lista.insert(6, 2);
		 
		System.out.println(lista.get(1));
		System.out.println(lista.getNode(2).next);
		System.out.println(lista.contains(6));
		lista.remove(2);
		System.out.println(lista.contains(6)); 
		System.out.println(lista.size);
		
	}
	
}