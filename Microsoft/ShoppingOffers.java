// class Solution {
//     public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//         return estimate(price,special,needs);
//     }

//     public int estimate(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        
//         int totalPrice = 0;
//         for(int i=0;i<price.size();i++){
//             totalPrice+=price.get(i)*needs.get(i);
//         }

//         for(int i=0;i<special.size();i++){
//             ArrayList<Integer> req = new ArrayList<>(needs);
//             int j=0;
//             for(;j<needs.size();j++){
//                 if(special.get(i).get(j) > req.get(j)){
//                     break;
//                 }
//                 req.set(j,req.get(j)-special.get(i).get(j)  );
//             }
//             if(j==needs.size()){
//                 int prev = totalPrice;
//                 totalPrice = Math.min(totalPrice,special.get(i).get(j)+estimate(price,special,req));
                
//             }
//         }
//         return totalPrice;
//     }
// }

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return estimate(price, special, needs, new HashMap<>());
    }

    public int estimate(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int totalPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            totalPrice += price.get(i) * needs.get(i);
        }
        for (List<Integer> offer : special) {
            List<Integer> req = new ArrayList<>(needs);
            int j = 0;
            for (; j < needs.size(); j++) {
                if (offer.get(j) > req.get(j)) {
                    break; 
                }
                req.set(j, req.get(j) - offer.get(j)); 
            }

            if (j == needs.size()) {
                totalPrice = Math.min(totalPrice, offer.get(j) + estimate(price, special, req, memo));
            }
        }

        memo.put(needs, totalPrice);
        return totalPrice;
    }
}
