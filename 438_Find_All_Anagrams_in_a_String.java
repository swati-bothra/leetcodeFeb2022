class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if(m>n){
            return ans;
        }
        HashMap<Character,Integer> smap=new HashMap<>();
        HashMap<Character,Integer> pmap=new HashMap<>();
        for(int i=0;i<m;i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=m;i<n;i++){
            if(compare(smap,pmap))ans.add(i-m);
            char c=s.charAt(i);
            smap.put(c,smap.getOrDefault(c,0)+1);
            char ch=s.charAt(i-m);
            if(smap.get(ch)>1){
                smap.put(ch,smap.get(ch)-1);
            }else{
                smap.remove(ch);
            }
        }
        if(compare(smap,pmap))ans.add(n-m);
        return ans;
    }
    boolean compare(HashMap<Character,Integer> smap,HashMap<Character,Integer> pmap){
        for(char c:smap.keySet()){
            if((int)pmap.getOrDefault(c,0)!=(int)smap.get(c))return false;
        }
        return true;
    }
}
