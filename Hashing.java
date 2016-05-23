//class for each HashEntry
public class HashEntry
{
    private int key;
    private int value;

    HashEntry(int key, int value)
    {
        this.key=key;
        this.value=value;
    }

    public int getValue()
    {
        return value;
    }

    public int getKey()
    {
        return key;
    }

    public void setValue(int value)
    {
        this.value=value;
    }
}

//class for implementing deletion of an entry
public class DeletedEntry extends HashEntry
{
    private static DeletedEntry entry=null;
    private DeletedEntry()
    {
        super(-1,-1);
    }

    public static DeletedEntry getUniqueDelEntry()
    {
        if(entry==null)
            entry=new DeletedEntry();
        return entry;
    }
}

public class HashTable
{
    //Limit the size of the hash table to 128
    private final static int TABLE_SIZE=128;

    //declare an array of type HashEntry
    HashEntry[] table;

    HashTable()
    {
        //instantiate the array
        table=new HashEntry[TABLE_SIZE];

        //initialize the array
        for(int i=0;i<128;i++)
        {
            table[i]=null;
        }

    }


    //function to get the value at the given key
    public int get(int key)
    {
        //hash function
        int hash=key % TABLE_SIZE;

        while(table[hash] != null && table[hash].getKey() != key)
            hash=(hash+1) % TABLE_SIZE; //linear probing

        if(table[hash]==null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value)
    {
        int hash=key % TABLE_SIZE;

        while (table[hash]!=null && table[hash].getKey()!=key)
            hash=(hash+1) % TABLE_SIZE;

        table[hash]=new HashEntry(key,value);
    }
}