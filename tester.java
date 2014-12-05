<<<<<<< HEAD
import businessLayer.AccountManage;
import businessLayer.Token;
import dataLayer.Db_base;
=======
import businessLayer.Account;

>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a


public class tester {

	public tester() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args){
<<<<<<< HEAD
		AccountManage a = new AccountManage("C1001", "DogCat");
 		a.test();
//       Db_base d = new Db_base();
//       d.connect();
  //         Token t = new Token("C1001","DogCat");     
=======
		Account a = new Account("C1001", "DogCat");
		a.test();
>>>>>>> ea04797f529047c6704fd3c1bc68e34b9cc44a0a
	}
}
