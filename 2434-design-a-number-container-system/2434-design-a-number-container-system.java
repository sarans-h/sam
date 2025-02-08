class NumberContainers {
    private Map<Integer, Integer> indexToNumber;
    private Map<Integer, TreeSet<Integer>> numberToIndex;


    public NumberContainers() {
        this.indexToNumber=new HashMap<>();
        this.numberToIndex=new HashMap<>();

    }
    
    public void change(int index, int number) {
        if(indexToNumber.containsKey(index)){
            int prev=indexToNumber.get(index);
            numberToIndex.get(prev).remove(index);
            if(numberToIndex.get(prev).isEmpty()){
                numberToIndex.remove(prev);
            }
        }
        indexToNumber.put(index,number);
        numberToIndex.putIfAbsent(number,new TreeSet<>());
        numberToIndex.get(number).add(index);
    }
    
    public int find(int number) {
        if(numberToIndex.containsKey(number)){
            return numberToIndex.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */