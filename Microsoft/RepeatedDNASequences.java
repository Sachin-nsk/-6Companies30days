class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> list = new ArrayList<>();
        int n = s.length();
        String temp ="";
        HashMap<String,Integer> mpp = new HashMap<>();
        for(int i=0;i<=n-10;i++){
            temp = s.substring(i,i+10);
            if(mpp.containsKey(temp)) mpp.put(temp,mpp.get(temp)+1);
            else mpp.put(temp,1);
            if(mpp.get(temp)==2) list.add(temp);
        }
        return list;

    }
}

/**
 * 1. Use hashmap technique 
2.temp = s.substring(i,i+10) traverse upto i<=n-10
 */