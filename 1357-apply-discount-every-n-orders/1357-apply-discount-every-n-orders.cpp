class Cashier {
public:
    int n;
    int discount;
    int count=0;
    vector<int>products;
    vector<int>prices;
    unordered_map<int,int>map;
    Cashier(int n, int discount, vector<int>& products, vector<int>& prices) {
        this->n=n;
        this->discount=discount;
        this->products=products;
        this->prices=prices;
        for(int i=0;i<products.size();i++){
            map[products[i]]=i;
        }
    }
    
    double getBill(vector<int> product, vector<int> amount) {
        count++;
        double ans=0.0;
        for(int i=0;i<product.size();i++){
            int index=map[product[i]];
            ans+=(prices[index]*amount[i]);
        }
        if(count%n==0){
            ans=(ans*((100.0-(double)discount)/100.0));
        }
        return ans;
    }
};

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier* obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj->getBill(product,amount);
 */