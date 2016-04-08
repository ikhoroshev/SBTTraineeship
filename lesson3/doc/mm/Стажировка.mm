<map version="1.0.1">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node CREATED="1459859373958" ID="ID_844487620" MODIFIED="1460028277997" TEXT="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1055;&#1086;&#1083;&#1077;&#1079;&#1085;&#1099;&#1077; &#1089;&#1089;&#1099;&#1083;&#1082;&#1080;:
    </p>
  </body>
</html>
</richcontent>
<node CREATED="1459859427985" ID="ID_1589096889" MODIFIED="1460005204783" POSITION="left" TEXT="&#x41c;&#x430;&#x441;&#x441;&#x438;&#x432;&#x44b;">
<arrowlink COLOR="#b0b0b0" DESTINATION="ID_1440380139" ENDARROW="Default" ENDINCLINATION="920;-313;" ID="Arrow_ID_1021111231" STARTARROW="None" STARTINCLINATION="898;-313;"/>
<icon BUILTIN="full-2"/>
<node CREATED="1459859905182" ID="ID_737945304" MODIFIED="1459867278137" TEXT="&#x41f;&#x43e;&#x43b;&#x435;&#x437;&#x43d;&#x44b;&#x435; &#x441;&#x441;&#x44b;&#x43b;&#x43a;&#x438;">
<node CREATED="1459860044684" ID="ID_1752292444" LINK="https://dzone.com/articles/covariance-and-contravariance" MODIFIED="1459860050321" TEXT="Covariance and Contravariance In Java"/>
<node CREATED="1459867303917" ID="ID_1174748159" LINK="http://shipilev.net/blog/2016/arrays-wisdom-ancients/" MODIFIED="1459867324696" TEXT="Arrays of Wisdom of the Ancients"/>
</node>
<node CREATED="1459924286036" ID="ID_1637229621" MODIFIED="1459924293184" TEXT="&#x441;&#x43f;&#x43e;&#x441;&#x43e;&#x431;&#x44b; &#x441;&#x43e;&#x437;&#x434;&#x430;&#x43d;&#x438;&#x44f;"/>
<node CREATED="1459924348758" ID="ID_1779005108" MODIFIED="1459924362675" TEXT="&#x43a;&#x43e;&#x43f;&#x438;&#x440;&#x43e;&#x432;&#x430;&#x43d;&#x438;&#x435;"/>
<node CREATED="1459924363574" ID="ID_454732606" MODIFIED="1459924365461" TEXT="&#x441;&#x440;&#x430;&#x432;&#x43d;&#x435;&#x43d;&#x438;&#x435;"/>
<node CREATED="1459924387977" ID="ID_590636385" MODIFIED="1460006763943" TEXT="&#x441;&#x43e;&#x440;&#x442;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Collections.sort
    </p>
    <p>
      Arrays.sort
    </p>
    <p>
      
    </p>
    <p>
      Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations.
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1459859438530" ID="ID_1505106338" MODIFIED="1460006320702" POSITION="left" STYLE="fork" TEXT="&#x41a;&#x43e;&#x43b;&#x43b;&#x435;&#x43a;&#x446;&#x438;&#x438;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      Java Collections API Design FAQ<br />http://docs.oracle.com/javase/1.5.0/docs/guide/collections/designfaq.html
    </p>
    <p>
      
    </p>
    <p>
      https://github.com/benblack86/java-snippets/blob/master/resources/java_collections.pdf
    </p>
    <p>
      http://bigocheatsheet.com/
    </p>
  </body>
</html></richcontent>
<icon BUILTIN="full-3"/>
<node CREATED="1460005445264" ID="ID_78719781" MODIFIED="1460035661330" TEXT="&#x422;&#x438;&#x43f;&#x44b;">
<node CREATED="1460005453871" ID="ID_1765249558" MODIFIED="1460035561325" TEXT="Map">
<node CREATED="1460006081613" FOLDED="true" ID="ID_617899239" MODIFIED="1460035552555" TEXT="HashMap">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;HashMap is the most popular map in JDK. Provided that it contains objects with a quality hashCode method and it has not too high load factor, it will generally give you O(1) performance of get and put methods (as well as similar methods like contains).
    </p>
    <p>
      
    </p>
    <p>
      You can find a proper hash map description in one of popular textbooks ( Algorithms (4th Edition) or Introduction to Algorithms ) or in Wikipedia. Here we will only discuss JDK HashMap implementation.
    </p>
    <p>
      
    </p>
    <p>
      HashMap is built on top of the array of Map.Entry objects. The implementation ensures that this array length is always equal to at least max( size, capacity ) / load_factor. Default load factor for HashMap is 0.75 and default capacity is 16. Load factor specifies which part of an array could be used for storage and is a value between 0 and 1. The higher is the load factor, the less space is being wasted, but HashMap starts to work slower due to increased rate of collisions. The smaller if the load factor, the more memory is wasted, but the performance of a HashMap is increasing due to smaller possibility of collisions.
    </p>
    <p>
      
    </p>
    <p>
      So, as you have seen, the default (new HashMap&lt;&gt;()) size of array of entries is 16 / 0.75 = 21.33 ~ 22.
    </p>
    <p>
      
    </p>
    <p>
      What is a HashMap.Entry? It contains a key, a value, int hash of a key and a pointer to the next entry (remember that entries array could be sparse). It means that an entry occupies 32 bytes (12 bytes header + 16 bytes data + 4 bytes padding). So, a HashMap with size = S has to spend 32 * S bytes for entries storage. Besides, it will use 4 * C bytes for entries array, where C is the map capacity.
    </p>
    <p>
      
    </p>
    <p>
      As you can see, if you will make the map capacity small enough (less than 12.5%), its entry array size will start dominating over the entries.
    </p>
    <p>
      
    </p>
    <p>
      &#160;A HashMap instance will occupy 32 * SIZE + 4 * CAPACITY bytes, while the theoretical map size limit could be equal to 8 * SIZE bytes (2 arrays of keys and values with no space wasted). Of course, such a &#8220;map&#8221; will require O(N) lookup time in general case. Though, in special cases, for example for EnumMap it could be as low as 4 * CAPACITY.
    </p>
    <p>
      
    </p>
    <p>
      Can we improve the hash map memory consumption without sacrificing O(1) lookup/add times? Surely, we can. Trove THashMap is a replacement implementation for HashMap. Internally THashMap contains 2 arrays &#8211; one for keys, another for values. It means that THashMap needs 8 * CAPACITY bytes for storage. Its default load factor is 0.5, but you can increase it if necessary.
    </p>
    <p>
      
    </p>
    <p>
      Let&#8217;s compare the memory usage of HashMap and THashMap with default load factors and size = 100. HashMap capacity will be 134 (100/0.75) and THashMap capacity will be 200 (100/0.5). The total memory consumption of a HashMap will be 32 * 100 + 4 * 134 = 3200 + 536 = 3736 bytes (not including the memory occupied by keys or values!). The memory consumption of THashMap will be 8 * 200 = 1600 bytes. Furthermore, if we will set THashMap load factor to 0.75 (thus making it equal to HashMap load factor), THashMap memory consumption will go down to 8 * 134 = 1072 bytes.
    </p>
    <p>
      
    </p>
    <p>
      As you can see, it worth to replace JDK HashMap with Trove THashMap if you want to save some memory.
    </p>
  </body>
</html>
</richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_617899239" ENDARROW="None" ENDINCLINATION="177;0;" ID="Arrow_ID_850546038" SOURCE="ID_1012105592" STARTARROW="None" STARTINCLINATION="177;0;"/>
<node CREATED="1460006087070" ID="ID_864678731" MODIFIED="1460035477246" TEXT="LinkedHashMap">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <code>LinkedHashMap</code>&#160;is <i>the</i>&#160;most memory-hungry collection in JDK. It extends <code>HashMap</code>&#160;by using <code>LinkedHashMap.Entry</code>&#160;as an entry in the internal array of entries. <code>LinkedHashMap.Entry</code>&#160; extends <code>HashMap.Entry</code>&#160;by adding &#8216;before&#8217; and &#8216;after&#8217; pointers, thus implementing a linked deque. For us it means that <code>LinkedHashMap.Entry</code>&#160; consumes 40 bytes (8 bytes more than <code>HashMap.Entry</code>).
    </p>
    <p>
      It means that <code>LinkedHashMap</code>&#160;consumes <strong>40 * SIZE + 4 * CAPACITY</strong>&#160; bytes. Unfortunately, Trove does not offer a direct replacement for this collection, but I would advise you to use a linked list if you want to store a small number of elements.
    </p>
  </body>
</html>
</richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_864678731" ENDARROW="None" ENDINCLINATION="74;0;" ID="Arrow_ID_595070157" SOURCE="ID_1012105592" STARTARROW="None" STARTINCLINATION="74;0;"/>
</node>
</node>
<node CREATED="1460006093934" ID="ID_1266421570" MODIFIED="1460006097979" TEXT="WeakHashMap"/>
<node CREATED="1460023881547" ID="ID_671879912" MODIFIED="1460035567633" TEXT="TreeMap">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      TreeMap is a red-black tree. This means that a tree contains exactly map.size() nodes. Each tree node contains: key, value, pointers to the left and right children, pointer to a parent and a boolean &#8216;colour&#8217; flag. It means that a node occupies 12 bytes for header, 20 bytes for 5 object fields and 1 byte for the flag, so the total consumption is 12 + 20 + 1 = 40 (due to 8 byte alignment). The last flag seems to be odd in this design, because it causes each node to consume 7 bytes more (due to alignment). This situation could be solved by having 2 types of nodes &#8211; one class for red nodes and another for black ones.
    </p>
    <p>
      
    </p>
    <p>
      So, the total memory consumption of a TreeMap is 40 * SIZE bytes, which is approximately the same as the memory consumption of a HashMap. In terms of CPU consumption, a TreeMap is worse &#8211; all of its methods have O(logN) complexity compared to O(1) of HashMap (provided that the load factor is low enough).
    </p>
    <p>
      
    </p>
    <p>
      The advantage of a TreeMap is that it implements a NavigableMap interface, which allows you to make cheap requests for previous/next entries by the natural ordering or provided Comparator as well as to make any range selections.
    </p>
  </body>
</html></richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_671879912" ENDARROW="Default" ENDINCLINATION="206;-24;" ID="Arrow_ID_402176417" SOURCE="ID_402575952" STARTARROW="None" STARTINCLINATION="346;-14;"/>
</node>
</node>
<node CREATED="1460005465441" ID="ID_779968409" MODIFIED="1460005499452" TEXT="Collection">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      since 1.2
    </p>
    <p>
      generics since 1.5
    </p>
  </body>
</html></richcontent>
<node CREATED="1459924480819" ID="ID_1908740993" MODIFIED="1460005357123" TEXT="&#x41c;&#x43d;&#x43e;&#x436;&#x435;&#x441;&#x442;&#x432;&#x43e; Set">
<node CREATED="1460034909152" ID="ID_1012105592" MODIFIED="1460035477246" TEXT="HashSet">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;JDK HashSet is built on top of a HashMap&lt;T, Object&gt;, where value is a singleton &#8216;present&#8217; object. It means that the memory consumption of a HashSet is identical to HashMap: in order to store SIZE values, you need 32 * SIZE + 4 * CAPACITY bytes (plus size of your values). It is definitely not a memory-friendly collection.
    </p>
    <p>
      
    </p>
    <p>
      Trove THashSet could be the easiest replacement collection for a HashSet &#8211; it implements Set&lt;E&gt; and Iterable&lt;E&gt;, which means you should just update a single letter in the initialization of your set.
    </p>
    <p>
      
    </p>
    <p>
      THashSet uses a single object array for its values, so it uses 4 * CAPACITY bytes for storage. As you can see, compared to JDK HashSet, you will save 32 * SIZE bytes in case of the identical load factor, which is a huge improvement.
    </p>
  </body>
</html>
</richcontent>
<arrowlink DESTINATION="ID_617899239" ENDARROW="None" ENDINCLINATION="177;0;" ID="Arrow_ID_850546038" STARTARROW="None" STARTINCLINATION="177;0;"/>
<arrowlink DESTINATION="ID_864678731" ENDARROW="None" ENDINCLINATION="74;0;" ID="Arrow_ID_595070157" STARTARROW="None" STARTINCLINATION="74;0;"/>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1012105592" ENDARROW="None" ENDINCLINATION="43;0;" ID="Arrow_ID_1773808423" SOURCE="ID_1507514354" STARTARROW="None" STARTINCLINATION="43;0;"/>
</node>
<node CREATED="1460035418459" ID="ID_1507514354" MODIFIED="1460035455031" TEXT="LinkedHashSet">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;JDK LinkedHashSet extends HashSet and adds nothing to it. It means the identical memory consumption of 32 * SIZE + 4 * CAPACITY bytes (plus size of your values).
    </p>
    <p>
      
    </p>
    <p>
      Trove TLinkedHashSet could be used as a replacement. It adds TIntList for storing the order of entries to THashSet, which means that it occupies 8 * CAPACITY bytes.
    </p>
  </body>
</html>
</richcontent>
<arrowlink DESTINATION="ID_1012105592" ENDARROW="None" ENDINCLINATION="43;0;" ID="Arrow_ID_1773808423" STARTARROW="None" STARTINCLINATION="43;0;"/>
</node>
<node CREATED="1460035530108" ID="ID_402575952" MODIFIED="1460035567633" TEXT="TreeSet ">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      JDK TreeSet is backed by a TreeMap, so its memory consumption is identical: 40 * SIZE bytes.
    </p>
  </body>
</html>
</richcontent>
<arrowlink DESTINATION="ID_671879912" ENDARROW="Default" ENDINCLINATION="206;-24;" ID="Arrow_ID_402176417" STARTARROW="None" STARTINCLINATION="346;-14;"/>
</node>
</node>
<node CREATED="1459924449436" ID="ID_379739741" MODIFIED="1460028303297" TEXT="List">
<node CREATED="1460011253414" ID="ID_1810977035" MODIFIED="1460011262580" TEXT="ArrayList">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <a href="http://java-performance.info/arraylist-performance/"><code>ArrayList</code></a>&#160;is one of the most efficient storage structures in JDK: it has an <code>Object[]</code>&#160;for storage plus an <code>int</code>&#160;field for tracking the list size (which is different from the array/list capacity = <code>array.length</code>). As long as you keep the actual objects in the <code>ArrayList</code>, it offers you near-optimal storage. All you need to remember about <code>ArrayList</code>&#160; is that it is better <strong>not</strong>&#160;to allocate a large <code>ArrayList</code>&#160;in advance if you are not sure that its capacity will be fully utilized. This is especially important for collections of such arrays (or collections of objects having array fields).
    </p>
    <p>
      Another important property of <code>ArrayList</code>&#160;to remember is that there is only one <code>ArrayList</code>&#160;method which shrinks its capacity &#8211; <code>ArrayList.trimToSize</code>. <code>clear/remove*</code>&#160;methods decrease <code>ArrayList</code>&#160;size instead of capacity. So, if you use an <code>ArrayList</code>&#160;as a buffer of some sort and you expect some high peaks in your data, but rather low average buffer size, then it may make sense for you to trim your <code>ArrayList</code>&#160; &#8220;manually&#8221; after that.
    </p>
    <p>
      If you have a list of <a href="http://java-performance.info/java-lang-byte-short-integer-long-character-boxing-and-unboxing/">numeric wrappers</a>, you&#8217;d better use <a href="http://java-performance.info/primitive-types-collections-trove-library/">Trove</a>&#160; <code>T[Type]ArrayList</code>, which allows you to store (and most important &#8211; keep) primitive values in those collections.
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1460012647981" ID="ID_1912797941" MODIFIED="1460029747558" TEXT="LinkedList">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      LinkedList is the only JDK collection which implements the two following interfaces: List and Deque, which makes it useful for iteration operations on queue/dequeue/stack structures.
    </p>
    <p>
      
    </p>
    <p>
      Due to being a deque, each LinkedList node contains references to the previous and next elements as well as a reference to the data value. Such node occupies 24 bytes (12 bytes header + 3*4 bytes for references), which is 6 times more than ArrayList in terms of per-node overhead. This structure is also CPU cache-unfriendly due to its spatial non-locality.<br /><br />1. &#1053;&#1077;&#1086;&#1073;&#1093;&#1086;&#1076;&#1080;&#1084;&#1086; &#1084;&#1085;&#1086;&#1075;&#1086; &#1076;&#1072;&#1085;&#1085;&#1099;&#1093; &#1076;&#1086;&#1073;&#1072;&#1074;&#1083;&#1103;&#1090;&#1100; &#1074; &#1085;&#1072;&#1095;&#1072;&#1083;&#1086; &#1089;&#1087;&#1080;&#1089;&#1082;&#1072;
    </p>
    <p>
      2. &#1059;&#1076;&#1072;&#1083;&#1103;&#1090;&#1100; &#1089; &#1085;&#1072;&#1095;&#1072;&#1083;&#1072; (index = 0) &#1089;&#1087;&#1080;&#1089;&#1082;&#1072;, &#1090;.&#1077;. &#1101;&#1083;&#1077;&#1084;&#1077;&#1085;&#1090;&#1099;, &#1082;&#1086;&#1090;&#1086;&#1088;&#1099;&#1077; &#1073;&#1099;&#1083;&#1080; &#1076;&#1086;&#1073;&#1072;&#1074;&#1083;&#1077;&#1085;&#1099; &#1087;&#1077;&#1088;&#1074;&#1099;&#1084;&#1080;.
    </p>
    <p>
      3. .set &#1074; &#1082;&#1086;&#1085;&#1094;&#1077; &#1089;&#1087;&#1080;&#1089;&#1082;&#1072;
    </p>
  </body>
</html>
</richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1912797941" ENDARROW="None" ENDINCLINATION="50;0;" ID="Arrow_ID_242344331" SOURCE="ID_977901790" STARTARROW="None" STARTINCLINATION="50;0;"/>
</node>
</node>
<node CREATED="1460029639182" ID="ID_977901790" MODIFIED="1460029747558" TEXT="ArrayDeque">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;If all you need is a FIFO/LIFO buffer and you don&#8217;t need to access anything except its head or tail, you&#8217;d better prefer ArrayDeque to LinkedList.
    </p>
    <p>
      
    </p>
    <p>
      ArrayDeque is based on an Object[], which length is a power of 2. Besides the array, there are int head and tail pointers &#8211; they allow the array to wrap around its edges if required. Because of ArrayDeque internal memory management, its storage array length is always equal to the size of ArrayDeque rounded to the next power of 2. It means that you spend less than 8 bytes per value in the worst case and 4 bytes per value in the best case.
    </p>
  </body>
</html>
</richcontent>
<arrowlink DESTINATION="ID_1912797941" ENDARROW="None" ENDINCLINATION="50;0;" ID="Arrow_ID_242344331" STARTARROW="None" STARTINCLINATION="50;0;"/>
</node>
<node CREATED="1459924506597" ID="ID_745120230" MODIFIED="1460006053096" TEXT="&#x41e;&#x447;&#x435;&#x440;&#x435;&#x434;&#x44c; Queue">
<node CREATED="1460035604112" ID="ID_867351900" MODIFIED="1460035614359" TEXT="PriorityQueue">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#160;The last collection to discuss is a PriorityQueue. This collection is used in scenarios when from time to time you need to extract/get the smallest (or the largest, depending on your settings) element in the collection as well as to add the new elements to the collection. Extraction and insertion are mixed without any particular order.
    </p>
    <p>
      
    </p>
    <p>
      PriorityQueue is based on the binary heap, which is essentially an array, where children of entry with index N are located at 2*N+1 and 2*N+2. The size of this array is increased twofold on each resize, so for sufficiently large collections we use between 50 and 100% of entries in the array. There are no wrappers for collection elements, which means that PriorityQueue consumption is between 4 * SIZE and 8 * SIZE bytes (identical to ArrayList despite their different purposes). We can also specify this size as 4 * CAPACITY bytes.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1460028373645" ID="ID_824164927" MODIFIED="1460029641087" TEXT="BitSet">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      As you have noticed from a previous section, a BitSet is built on top of the long[]. The minor disadvantage of a BitSet is that its minimal allowed value is fixed to zero. Thus, if you need a BitSet starting at some offset, you will have to manually subtract your offset from all your values in BitSet methods. Besides that, a BitSet is limited to int values. It also means a need of some sort of envelope for storing real long values in it.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node CREATED="1460011747971" FOLDED="true" ID="ID_1367053320" MODIFIED="1460035615504" TEXT="&#x442;&#x430;&#x431;&#x43b;&#x438;&#x446;&#x430;">
<node CREATED="1460011754425" MODIFIED="1460011754425">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;_387670365616666664.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1460011315760" FOLDED="true" ID="ID_1139964483" LINK="http://java-performance.info/memory-consumption-of-java-data-types-1/" MODIFIED="1460028288391" TEXT="&#x423;&#x442;&#x438;&#x43b;&#x438;&#x437;&#x430;&#x446;&#x438;&#x44f; &#x440;&#x435;&#x441;&#x443;&#x440;&#x441;&#x43e;&#x432;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <table border="1">
      <tr>
        <td>
          <code>EnumSet</code>, <code>BitSet</code>
        </td>
        <td>
          1 bit per value
        </td>
      </tr>
      <tr>
        <td>
          <code>EnumMap</code>
        </td>
        <td>
          4 bytes (for value, nothing for key)
        </td>
      </tr>
      <tr>
        <td>
          <code>ArrayList</code>
        </td>
        <td>
          4 bytes (but may be more if <code>ArrayList</code>&#160;capacity is seriously more than its size)
        </td>
      </tr>
      <tr>
        <td>
          <code>LinkedList</code>
        </td>
        <td>
          24 bytes (fixed)
        </td>
      </tr>
      <tr>
        <td>
          <code>ArrayDeque</code>
        </td>
        <td>
          4 to 8 bytes, 6 bytes on average
        </td>
      </tr>
    </table>
    <p>
      
    </p>
    <table border="1">
      <tr>
        <td>
          JDK collection
        </td>
        <td>
          Size
        </td>
        <td>
          Possible Trove substitution
        </td>
        <td>
          Size
        </td>
      </tr>
      <tr>
        <td>
          <code>HashMap</code>
        </td>
        <td>
          32 * SIZE + 4 * CAPACITY bytes
        </td>
        <td>
          <code>THashMap</code>
        </td>
        <td>
          8 * CAPACITY bytes
        </td>
      </tr>
      <tr>
        <td>
          <code>HashSet</code>
        </td>
        <td>
          32 * SIZE + 4 * CAPACITY bytes
        </td>
        <td>
          <code>THashSet</code>
        </td>
        <td>
          4 * CAPACITY bytes
        </td>
      </tr>
      <tr>
        <td>
          <code>LinkedHashMap</code>
        </td>
        <td>
          40 * SIZE + 4 * CAPACITY bytes
        </td>
        <td>
          None
        </td>
        <td>
          &#160;
        </td>
      </tr>
      <tr>
        <td>
          <code>LinkedHashSet</code>
        </td>
        <td>
          32 * SIZE + 4 * CAPACITY bytes
        </td>
        <td>
          <code>TLinkedHashSet</code>
        </td>
        <td>
          8 * CAPACITY bytes
        </td>
      </tr>
      <tr>
        <td>
          <code>TreeMap, TreeSet</code>
        </td>
        <td>
          40 * SIZE bytes
        </td>
        <td>
          None
        </td>
        <td>
          &#160;
        </td>
      </tr>
      <tr>
        <td>
          <code>PriorityQueue</code>
        </td>
        <td>
          4 * CAPACITY bytes
        </td>
        <td>
          None
        </td>
        <td>
          &#160;
        </td>
      </tr>
    </table>
  </body>
</html></richcontent>
<node CREATED="1460012228375" ID="ID_386273254" MODIFIED="1460012228375">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;_6063648453719846769.jpeg" />
  </body>
</html></richcontent>
</node>
<node CREATED="1460012271354" MODIFIED="1460012271354">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;_2923932732917619359.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1460012188519" FOLDED="true" ID="ID_948285528" LINK="https://habrahabr.ru/post/188010/" MODIFIED="1460024118548" TEXT="&#x412;&#x440;&#x435;&#x43c;&#x435;&#x43d;&#x43d;&#x430;&#x44f; &#x441;&#x43b;&#x43e;&#x436;&#x43d;&#x43e;&#x441;&#x442;&#x44c;">
<node CREATED="1460012196579" ID="ID_671689421" MODIFIED="1460012196579">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;_1988396153945818201.jpeg" />
  </body>
</html></richcontent>
</node>
<node CREATED="1460024109694" MODIFIED="1460024109694">
<richcontent TYPE="NODE"><html>
  <head>
    
  </head>
  <body>
    <img src="&#x421;&#x442;&#x430;&#x436;&#x438;&#x440;&#x43e;&#x432;&#x43a;&#x430;_9093438216249016884.jpeg" />
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1459859665227" ID="ID_521452344" MODIFIED="1460005357122" TEXT="Comparable">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Implementing <code>Comparable</code>&#160;indicates that objects have natural ordering
      </li>
      <li>
        <code>Comparable</code>&#160;allow to use your class in many generic algorithms: search, sorting, etc.
      </li>
      <li>
        <code>compareTo</code>&#160;should be consistent with <code>equals</code>
      </li>
      <li>
        Implement <code>compareTo</code>&#160;that returns <code>-1</code>, <code>0</code>&#160;and <code>1</code>&#160; and do not cause integer overflow
      </li>
      <li>
        For non-natural ordering or inability to implement <code>Comparable</code>&#160;use <code>Comparator</code>
      </li>
    </ul>
  </body>
</html></richcontent>
</node>
<node CREATED="1459924457347" ID="ID_999134934" MODIFIED="1460005357123" TEXT="Iterator"/>
<node CREATED="1459924473003" ID="ID_81989227" MODIFIED="1460005357123" TEXT="&#x421;&#x442;&#x435;&#x43a;"/>
<node CREATED="1459924517565" ID="ID_304328810" MODIFIED="1460005357123" TEXT="foreach"/>
<node CREATED="1459859724118" ID="ID_1922897366" MODIFIED="1460005554356" TEXT="&#x421;&#x43e;&#x432;&#x435;&#x442;&#x44b;">
<node CREATED="1459859784632" ID="ID_1258683944" MODIFIED="1460005357122" TEXT="Prefer lists to arrays">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Arrays are covariant (if <code>Sub</code>&#160;is subtype of <code>Super</code>, then <code>Sub[]</code>&#160; is a subtype of <code>Super[]</code>)
      </li>
      <li>
        Generics are invariant (<code>List&lt;Sub&gt;</code>&#160;is not a subtype of <code>List&lt;Super&gt;</code>)
      </li>
      <li>
        Arrays are reified (enforce their element types at runtime)
      </li>
      <li>
        Generics are non-reified and implemented by erasure (enforce types at a compile time, but erased at a runtime)
      </li>
      <li>
        Generic array creation errors at compile time (<code>List&lt;E&gt;[]</code>)
      </li>
      <li>
        Array of non-reified types can not be created
      </li>
    </ul>
  </body>
</html></richcontent>
<font BOLD="true" NAME="SansSerif" SIZE="12"/>
</node>
<node CREATED="1459859730047" ID="ID_879436008" MODIFIED="1460005357122" TEXT="Don&apos;t use raw types in new code">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Generic types provide compile-time checking for incompatible types
      </li>
      <li>
        Not needed manual cast to type when you retrieve element from collections
      </li>
      <li>
        Raw types exists only for backward compatibility
      </li>
      <li>
        You lose type safety if you use a raw type
      </li>
      <li>
        Raw types could be used with <code>instanceof</code>&#160;operator
      </li>
    </ul>
  </body>
</html></richcontent>
</node>
<node CREATED="1459859766041" ID="ID_2347196" MODIFIED="1460005357122" TEXT="Eliminate unchecked warnings">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        Eliminate every unchecked warning that you can, that means your code is typesafe
      </li>
      <li>
        Use <code>@SuppressWarnings(&quot;unchecked&quot;)</code>&#160;only if you can prove the code is typesafe
      </li>
      <li>
        Always use the <code>@SuppressWarnings</code>&#160;annotation on the smallest scope possible
      </li>
      <li>
        Every time you use an <code>@SuppressWarnings</code>&#160;annotation, add a comment saying why it's safe to do so
      </li>
      <li>
        Every unchecked warning represents the potential for a <code>ClassCastException</code>&#160; at runtime. Do not ignore them blindly
      </li>
    </ul>
  </body>
</html></richcontent>
</node>
</node>
</node>
<node CREATED="1459859427356" FOLDED="true" ID="ID_1115634716" LINK="https://docs.oracle.com/javase/tutorial/java/generics/types.html" MODIFIED="1460006871010" POSITION="right" TEXT="&#x41f;&#x430;&#x440;&#x430;&#x43c;&#x435;&#x442;&#x440;&#x438;&#x437;&#x438;&#x440;&#x43e;&#x432;&#x430;&#x43d;&#x43d;&#x44b;&#x435; &#x442;&#x438;&#x43f;&#x44b;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <ul>
      <li>
        E - Element (used extensively by the Java Collections Framework)
      </li>
      <li>
        K - Key
      </li>
      <li>
        N - Number
      </li>
      <li>
        T - Type
      </li>
      <li>
        V - Value
      </li>
      <li>
        S,U,V etc. - 2nd, 3rd, 4th types
      </li>
    </ul>
  </body>
</html></richcontent>
<icon BUILTIN="full-1"/>
<node CREATED="1459860012378" ID="ID_1878149510" LINK="http://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.6" MODIFIED="1459863364950" TEXT="Type Erasure">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    &#1089;&#1090;&#1080;&#1088;&#1072;&#1085;&#1080;&#1077; &#1090;&#1080;&#1087;&#1086;&#1074;
  </body>
</html></richcontent>
</node>
<node CREATED="1442223917425" ID="ID_361846194" MODIFIED="1460005532232" TEXT="Polymorphism">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1055;&#1088;&#1077;&#1076;&#1086;&#1089;&#1090;&#1072;&#1074;&#1083;&#1077;&#1085;&#1080;&#1077; &#1077;&#1076;&#1080;&#1085;&#1086;&#1075;&#1086; &#1080;&#1085;&#1090;&#1077;&#1088;&#1092;&#1077;&#1081;&#1089;&#1072; &#1076;&#1083;&#1103; &#1086;&#1073;&#1088;&#1072;&#1073;&#1086;&#1090;&#1082;&#1080; &#1076;&#1072;&#1085;&#1085;&#1099;&#1093; &#1088;&#1072;&#1079;&#1085;&#1086;&#1075;&#1086; &#1090;&#1080;&#1087;&#1072;.
    </p>
    <p>
      + &#1083;&#1077;&#1075;&#1082;&#1086; &#1088;&#1072;&#1089;&#1096;&#1080;&#1088;&#1103;&#1090;&#1100; &#1080; &#1084;&#1086;&#1076;&#1077;&#1088;&#1085;&#1080;&#1079;&#1080;&#1088;&#1086;&#1074;&#1072;&#1090;&#1100; &#1089;&#1080;&#1089;&#1090;&#1077;&#1084;&#1091;
    </p>
    <p>
      - &#1085;&#1077; &#1089;&#1083;&#1077;&#1076;&#1091;&#1077;&#1090; &#1079;&#1083;&#1086;&#1091;&#1087;&#1086;&#1090;&#1088;&#1077;&#1073;&#1083;&#1103;&#1090;&#1100; &#1087;&#1086;&#1083;&#1080;&#1084;&#1086;&#1088;&#1092;&#1080;&#1079;&#1084;&#1086;&#1084; &#1089; &#1094;&#1077;&#1083;&#1100;&#1102; &#1086;&#1073;&#1077;&#1089;&#1087;&#1077;&#1095;&#1077;&#1085;&#1080;&#1103; &#1076;&#1077;&#1077;&#1089;&#1087;&#1086;&#1089;&#1086;&#1073;&#1085;&#1086;&#1089;&#1090;&#1080; &#1089;&#1080;&#1089;&#1090;&#1077;&#1084;&#1099; &#1074; &#1085;&#1077;&#1080;&#1079;&#1074;&#1077;&#1089;&#1090;&#1085;&#1099;&#1093; &#1079;&#1072;&#1088;&#1072;&#1085;&#1077;&#1077; &#1085;&#1086;&#1074;&#1099;&#1093; &#1089;&#1080;&#1090;&#1091;&#1072;&#1094;&#1080;&#1103;&#1093;
    </p>
  </body>
</html></richcontent>
<node CREATED="1442224241305" ID="ID_1477093256" MODIFIED="1460003125422" TEXT="Static">
<node CREATED="1442224043356" ID="ID_975740516" MODIFIED="1442224115492" TEXT="Overloading">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1087;&#1077;&#1088;&#1077;&#1075;&#1088;&#1091;&#1079;&#1082;&#1072;
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1442224088246" ID="ID_148862774" MODIFIED="1460005612876" TEXT="Generic">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1076;&#1078;&#1080;&#1085;&#1077;&#1088;&#1080;&#1082;&#1080;
    </p>
  </body>
</html></richcontent>
<arrowlink DESTINATION="ID_1683417092" ENDARROW="None" ENDINCLINATION="279;0;" ID="Arrow_ID_1936944454" STARTARROW="None" STARTINCLINATION="279;0;"/>
<node CREATED="1459968305395" ID="ID_207042754" MODIFIED="1460005542470" TEXT="&#x41c;&#x43d;&#x43e;&#x433;&#x43e;&#x443;&#x433;&#x43e;&#x43b;&#x44c;&#x43d;&#x438;&#x43a;">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      number of sides
    </p>
  </body>
</html></richcontent>
<node CREATED="1459968372141" ID="ID_399969570" MODIFIED="1459968375929" TEXT="&#x442;&#x440;&#x435;&#x443;&#x433;&#x43e;&#x43b;&#x44c;&#x43d;&#x438;&#x43a;">
<node CREATED="1459968379740" ID="ID_685215167" MODIFIED="1459968407593" TEXT="&#x43e;&#x441;&#x442;&#x440;&#x43e;&#x443;&#x433;&#x43e;&#x43b;&#x44c;&#x43d;&#x44b;&#x439;"/>
<node CREATED="1459968412291" ID="ID_1957814829" MODIFIED="1459968417385" TEXT="&#x442;&#x443;&#x43f;&#x43e;&#x443;&#x433;&#x43e;&#x43b;&#x44c;&#x43d;&#x44b;&#x439;"/>
<node CREATED="1459968421262" ID="ID_778353207" MODIFIED="1459968424905" TEXT="&#x43f;&#x440;&#x44f;&#x43c;&#x43e;&#x443;&#x433;&#x43b;&#x44c;&#x43d;&#x44b;&#x439;"/>
<node CREATED="1459968435872" ID="ID_1213656978" MODIFIED="1459968439577" TEXT="&#x440;&#x430;&#x432;&#x43d;&#x43e;&#x431;&#x435;&#x434;&#x440;&#x435;&#x43d;&#x43d;&#x44b;&#x439;"/>
<node CREATED="1459968440700" ID="ID_1222486370" MODIFIED="1459968443690" TEXT="&#x440;&#x430;&#x432;&#x43d;&#x43e;&#x441;&#x442;&#x43e;&#x440;&#x43e;&#x43d;&#x43d;&#x438;&#x439;"/>
</node>
<node CREATED="1459968573846" ID="ID_513207098" MODIFIED="1459968581267" TEXT="&#x447;&#x435;&#x442;&#x44b;&#x440;&#x435;&#x445;&#x443;&#x433;&#x43e;&#x43b;&#x44c;&#x43d;&#x438;&#x43a;">
<node CREATED="1459968646583" ID="ID_1983987621" MODIFIED="1459968653237" TEXT="&#x440;&#x430;&#x432;&#x43d;&#x43e;&#x431;&#x435;&#x434;&#x440;&#x435;&#x43d;&#x43d;&#x430;&#x44f; &#x442;&#x440;&#x430;&#x43f;&#x435;&#x446;&#x438;&#x44f;">
<node CREATED="1459968655688" ID="ID_1306659918" MODIFIED="1459968660612" TEXT="&#x43f;&#x440;&#x44f;&#x43c;&#x43e;&#x443;&#x433;&#x43b;&#x44c;&#x43d;&#x438;&#x43a;">
<node CREATED="1459968664743" ID="ID_245192709" MODIFIED="1459968666900" TEXT="&#x43a;&#x432;&#x430;&#x434;&#x440;&#x430;&#x442;"/>
</node>
</node>
</node>
<node CREATED="1459968604057" ID="ID_1919184486" MODIFIED="1459968608261" TEXT="&#x43d;&#x435;&#x432;&#x44b;&#x43f;&#x443;&#x43a;&#x43b;&#x44b;&#x439;"/>
<node CREATED="1459968609673" ID="ID_505677490" MODIFIED="1459968611717" TEXT="&#x432;&#x44b;&#x43f;&#x443;&#x43a;&#x43b;&#x44b;&#x439;"/>
<node CREATED="1459968612648" ID="ID_620847048" MODIFIED="1459968618310" TEXT="&#x441;&#x430;&#x43c;&#x43e;&#x43f;&#x435;&#x440;&#x435;&#x441;&#x435;&#x43a;&#x430;&#x44e;&#x449;&#x438;&#x439;&#x441;&#x44f;"/>
</node>
</node>
</node>
<node CREATED="1442224251200" ID="ID_1793621663" MODIFIED="1459863467603" TEXT="Dynamic">
<node CREATED="1442224097460" ID="ID_1130616919" MODIFIED="1442403703347" TEXT="Subtyping">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1074;&#1082;&#1083;&#1102;&#1095;&#1077;&#1085;&#1080;&#1077; &#1085;&#1072; &#1091;&#1088;&#1086;&#1074;&#1085;&#1077; &#1080;&#1085;&#1090;&#1077;&#1088;&#1092;&#1077;&#1081;&#1089;&#1086;&#1074;&#160;(&#1076;&#1080;&#1085;&#1072;&#1084;&#1080;&#1095;&#1077;&#1089;&#1082;&#1080;)
    </p>
    <p>
      &#1054;&#1087;&#1088;&#1077;&#1076;&#1077;&#1083;&#1077;&#1085;&#1080;&#1077; &#1056;&#1086;&#1073;&#1077;&#1088;&#1090;&#1072; &#1052;&#1072;&#1088;&#1090;&#1080;&#1085;&#1072;:
    </p>
  </body>
</html></richcontent>
</node>
</node>
<node CREATED="1460003342294" ID="ID_1828569513" MODIFIED="1460003347013" TEXT="ad-hoc">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    Ad hoc polymorphism refers to polymorphic functions that can be applied to different argument types known by the same name in a programming language. Ad hoc polymorphism is also known as function overloading or operator overloading because a polymorphic function can represent a number of unique and potentially heterogeneous implementations depending on the type of argument it is applied to
  </body>
</html></richcontent>
<node CREATED="1460003375776" ID="ID_781260278" MODIFIED="1460003379899" TEXT="aspekt"/>
</node>
</node>
<node CREATED="1459863561794" ID="ID_696576647" MODIFIED="1460003366976" TEXT="&#x41a;&#x43e;&#x432;&#x430;&#x440;&#x438;&#x430;&#x446;&#x438;&#x44f; &#x438; &#x43a;&#x43e;&#x43d;&#x442;&#x440;&#x430;&#x432;&#x430;&#x440;&#x438;&#x430;&#x446;&#x438;&#x44f; &#x432; &#x443;&#x43d;&#x438;&#x432;&#x435;&#x440;&#x441;&#x430;&#x43b;&#x44c;&#x43d;&#x44b;&#x445; &#x448;&#x430;&#x431;&#x43b;&#x43e;&#x43d;&#x430;&#x445;">
<node CREATED="1459863735538" ID="ID_1440380139" MODIFIED="1459863957783" TEXT="Covariance">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      &#1055;&#1086;&#1079;&#1074;&#1086;&#1083;&#1103;&#1077;&#1090; &#1080;&#1089;&#1087;&#1086;&#1083;&#1100;&#1079;&#1086;&#1074;&#1072;&#1090;&#1100; &#1090;&#1080;&#1087; &#1089; &#1073;&#1086;&#1083;&#1100;&#1096;&#1077;&#1081; &#1075;&#1083;&#1091;&#1073;&#1080;&#1085;&#1086;&#1081; &#1085;&#1072;&#1089;&#1083;&#1077;&#1076;&#1086;&#1074;&#1072;&#1085;&#1080;&#1103;, &#1095;&#1077;&#1084; &#1079;&#1072;&#1076;&#1072;&#1085;&#1086; &#1080;&#1079;&#1085;&#1072;&#1095;&#1072;&#1083;&#1100;&#1085;&#1086;. </sentencetext>
    </p>
    <p>
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      </sentencetext>
      </sentencetext>
      
    </p>
    <p>
      &#1055;&#1088;&#1077;&#1076;&#1087;&#1086;&#1083;&#1072;&#1075;&#1072;&#1077;&#1090;&#1089;&#1103; &#1087;&#1088;&#1080;&#1074;&#1080;&#1076;&#1077;&#1085;&#1080;&#1077; &#1086;&#1073;&#1077;&#1082;&#1090;&#1072; &#1087;&#1088;&#1086;&#1080;&#1079;&#1074;&#1086;&#1076;&#1085;&#1086;&#1075;&#1086; &#1090;&#1080;&#1087;&#1072; &#1082; &#1073;&#1072;&#1079;&#1086;&#1074;&#1086;&#1084;&#1091; &#1090;&#1080;&#1087;&#1091;.
    </p>
    <p>
      <code>List&lt;? extends Animal&gt;</code>&#160;&#1073;&#1091;&#1076;&#1077;&#1090; &#1082;&#1086;&#1074;&#1072;&#1088;&#1080;&#1072;&#1085;&#1090;&#1077;&#1085; &#1087;&#1086;&#1076;&#1089;&#1090;&#1072;&#1074;&#1083;&#1103;&#1077;&#1084;&#1086;&#1084;&#1091; &#1090;&#1080;&#1087;&#1091;
    </p>
  </body>
</html></richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1440380139" ENDARROW="Default" ENDINCLINATION="920;-313;" ID="Arrow_ID_1021111231" SOURCE="ID_1589096889" STARTARROW="None" STARTINCLINATION="898;-313;"/>
</node>
<node CREATED="1459863767648" ID="ID_292832062" MODIFIED="1459863923481" TEXT="Contravariance">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      &#1055;&#1086;&#1079;&#1074;&#1086;&#1083;&#1103;&#1077;&#1090; &#1080;&#1089;&#1087;&#1086;&#1083;&#1100;&#1079;&#1086;&#1074;&#1072;&#1090;&#1100; &#1073;&#1086;&#1083;&#1077;&#1077; &#1091;&#1085;&#1080;&#1074;&#1077;&#1088;&#1089;&#1072;&#1083;&#1100;&#1085;&#1099;&#1081; &#1090;&#1080;&#1087; (&#1089; &#1084;&#1077;&#1085;&#1100;&#1096;&#1077;&#1081; &#1075;&#1083;&#1091;&#1073;&#1080;&#1085;&#1086;&#1081; &#1085;&#1072;&#1089;&#1083;&#1077;&#1076;&#1086;&#1074;&#1072;&#1085;&#1080;&#1103;), &#1095;&#1077;&#1084; &#1079;&#1072;&#1076;&#1072;&#1085;&#1085;&#1099;&#1081; &#1080;&#1079;&#1085;&#1072;&#1095;&#1072;&#1083;&#1100;&#1085;&#1086;.</sentencetext>
    </p>
    <p>
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      <sentencetext xmlns="http://www.w3.org/1999/xhtml">
      </sentencetext>
      </sentencetext>
      
    </p>
    <p>
      &#1055;&#1088;&#1077;&#1076;&#1087;&#1086;&#1083;&#1072;&#1075;&#1072;&#1077;&#1090;&#1089;&#1103; &#1087;&#1088;&#1080;&#1074;&#1080;&#1076;&#1077;&#1085;&#1080;&#1077; &#1086;&#1073;&#1077;&#1082;&#1090;&#1072; &#1073;&#1072;&#1079;&#1086;&#1074;&#1086;&#1075;&#1086; &#1090;&#1080;&#1087;&#1072; &#1082;&#160;&#1087;&#1088;&#1086;&#1080;&#1079;&#1074;&#1086;&#1076;&#1085;&#1086;&#1084;&#1091; &#1090;&#1080;&#1087;&#1091;.
    </p>
    <p>
      <code>List&lt;? super Animal&gt;</code>&#160;&#8212; &#1082;&#1086;&#1085;&#1090;&#1088;&#1072;&#1074;&#1072;&#1088;&#1080;&#1072;&#1085;&#1090;&#1077;&#1085;
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html></richcontent>
</node>
<node CREATED="1459863776527" ID="ID_1683417092" MODIFIED="1460005612876" TEXT="Invariance">
<richcontent TYPE="NOTE"><html>
  <head>
    
  </head>
  <body>
    <p>
      &#1054;&#1079;&#1085;&#1072;&#1095;&#1072;&#1077;&#1090;, &#1095;&#1090;&#1086; &#1084;&#1086;&#1078;&#1085;&#1086; &#1080;&#1089;&#1087;&#1086;&#1083;&#1100;&#1079;&#1086;&#1074;&#1072;&#1090;&#1100; &#1090;&#1086;&#1083;&#1100;&#1082;&#1086; &#1080;&#1079;&#1085;&#1072;&#1095;&#1072;&#1083;&#1100;&#1085;&#1086; &#1079;&#1072;&#1076;&#1072;&#1085;&#1085;&#1099;&#1081; &#1090;&#1080;&#1087;. &#1058;&#1072;&#1082;&#1080;&#1084; &#1086;&#1073;&#1088;&#1072;&#1079;&#1086;&#1084;, &#1087;&#1072;&#1088;&#1072;&#1084;&#1077;&#1090;&#1088; &#1080;&#1085;&#1074;&#1072;&#1088;&#1080;&#1072;&#1085;&#1090;&#1085;&#1086;&#1075;&#1086; &#1091;&#1085;&#1080;&#1074;&#1077;&#1088;&#1089;&#1072;&#1083;&#1100;&#1085;&#1086;&#1075;&#1086; &#1090;&#1080;&#1087;&#1072; &#1085;&#1077; &#1103;&#1074;&#1083;&#1103;&#1077;&#1090;&#1089;&#1103; &#1085;&#1080; &#1082;&#1086;&#1074;&#1072;&#1088;&#1080;&#1072;&#1085;&#1090;&#1085;&#1099;&#1084;, &#1085;&#1080; &#1082;&#1086;&#1085;&#1090;&#1088;&#1072;&#1074;&#1072;&#1088;&#1080;&#1072;&#1085;&#1090;&#1085;&#1099;&#1084;.
    </p>
  </body>
</html></richcontent>
<linktarget COLOR="#b0b0b0" DESTINATION="ID_1683417092" ENDARROW="None" ENDINCLINATION="279;0;" ID="Arrow_ID_1936944454" SOURCE="ID_148862774" STARTARROW="None" STARTINCLINATION="279;0;"/>
</node>
</node>
</node>
</node>
</map>
