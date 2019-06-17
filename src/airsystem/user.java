/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airsystem;

/**
 *
 * @author admin
 */
class user {
    private String  airline,stops,depart,arrives,price,sno;
    public user(String airline,String stops,String depart,String arrives,String price,String sno)
    {
    this.sno=sno;
     this.airline=airline;
      this.depart=depart;
       this.arrives=arrives;
        this.price=price;
         this.stops=stops;
    }
    public String getsno()
    {
        return sno;
    }
      public String getairline()
    {
        return airline;
    }
        public String getstops()
    {
        return stops;
    }
          public String getarrives()
    {
        return arrives;
    }
            public String getdepart()
    {
        return depart;
    }
              public String getprice()
    {
        return price;
    }
}
