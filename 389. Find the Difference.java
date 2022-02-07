class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)+1);
        }
        for(char c:t.toCharArray()){
            if(!map.containsKey(c)||map.get(c)==0){
                return c;
            }else{
                map.put(c,map.get(c)-1);
            }
        }
        return 'x';
    }
}
