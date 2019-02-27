package edu.gatech.cs2340.spacetraders.model;

public class TradeGood {
    private String name;
    private int mtlp; //minimum tech level to produce this resource. can't buy on planets below this level
    private int mtlu; //Minimum Tech Level to Use this resource (You can't sell on planets below this level)
    private int ttp; //Tech Level which produces the most of this item
    private int ipl; //Price increase per tech level
    private int var; //variance is the maximum percentage that the price can vary above or below the base
    private Condition ie; //Radical price increase event, when this even happens on a planet, the price may increase astronomically
    private Resources cr; //When this condition is present, the price of this resource is unusually low
    private Resources er; //When this condition is present, the resource is expensive
    private int mtl; //Min price offered in space trade with random trader (not on a planet)
    private int mth; //Max price offered in space trade with random trader (not on a planet)
    private int basePrice; //base price for the good
    private int finalPrice;

    public TradeGood(String n, int mtlp, int mtlu, int ttp, int ipl, int var, Condition ie, Resources cr, Resources er, int mtl, int mth, int base) {
        this.name = n;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
        basePrice = base;
        finalPrice = base;
    }
    public String getName() {
        return name;
    }
    public int getMtlp() {
        return mtlp;
    }
    public int getMtlu() {
        return mtlu;
    }
    public int getTtp() {
        return ttp;
    }
    public int getIpl() {
        return ipl;
    }
    public int getVar() {
        return var;
    }
    public Condition getIe() {
        return ie;
    }
    public Resources getCr() {
        return cr;
    }
    public Resources getEr() {
        return er;
    }
    public int getMtl() {
        return mtl;
    }
    public int getMth() {
        return mth;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public int getFinalPrice() {
        return finalPrice;
    }
    public void setFinalPrice(int p) {
        finalPrice = p;
    }

}
