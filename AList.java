public class AList<Item> implements List<Item>{
	/* the stored integers */
	private Item[] items;
	private int size;

	private static int RFACTOR = 2;

    /** Creates an empty list. */
    public AList() {
    	size = 0;
    	items = (Item[]) new Object[100];
    }

    /** Resize our backing array so that it is
      * of the given capacity. */
    private void resize(int capacity) {
    	Item[] a = (Item[]) new Object[capacity];
    	System.arraycopy(items, 0, a, 0, size);
    	items = a;    	
    }

    /** Inserts X into the back of the list. */
    @Override
    public void insertBack(Item x) {    	
    	if (size == items.length) {
    		resize(size * RFACTOR);
    	}

    	items[size] = x;
    	size = size + 1;
    }

    /** Returns the item from the back of the list. */
    @Override
    public Item getBack() {
    	int lastActualItemIndex = size - 1;
    	return items[lastActualItemIndex];
    }
    /** Gets the ith item in the list (0 is the front). */
    @Override
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    @Override
    public Item deleteBack() {
		Item itemToReturn = getBack();
		/* setting to zero not strictly necessary, but
		 * it's a good habit (we'll see why soon) */
		items[size - 1] = null;
		size = size - 1;
		return itemToReturn;
    }

    /** Inserts item into given position.
      * Code from discussion #3 */
    @Override
    public void insert(Item x, int position) {
        Item[] newItems = (Item[]) new Object[items.length + 1];

        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;

        System.arraycopy(items, position, newItems, position + 1, items.length - position);
        items = newItems;
    }

    /** Inserts an item at the front. */
    @Override
    public void insertFront(Item x) {
        insert(x, 0);
    }

    /** Gets an item from the front. */
    @Override
    public Item getFront() {
        return get(0);
    }

} 