import java.util.ArrayList;

public class UserManagement {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
      public UserManagement() {
		// TODO Auto-generated constructor stub
	}

    public UserManagement(String username, String password, String email, String firstName, String lastName, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    private static ArrayList<UserManagement> UserList = new ArrayList<UserManagement>();
    private static ArrayList<UserManagement> AdminList = new ArrayList<UserManagement>();

    public static void initAdmin(){
        UserManagement adminObj =  new UserManagement("admin1","password","johndoe@gmail.com","justin","kwek","+8412123123123");
        AdminList.add(adminObj);
    }

    public static  ArrayList<UserManagement> getUserList (){
            return UserList;
    }


	public static String[]  userNameAndPassWordAsker() {
        String  userNameAndPassWord [] = new String[2];
        String userName;
        String password;
        userName = Helper.readString("Enter user name");
        userNameAndPassWord[0] = userName;
        password = Helper.readString("Enter password");
        userNameAndPassWord[1] = password;
        return userNameAndPassWord;
    }

    public static boolean checkUserAuth(String username, String password) {
    	for (UserManagement user : UserList) {
            System.out.println(user.getUsername() +  user.getPassword());
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return  true;

            }
        }
        return  false;
    }

    public static boolean checkAdminAuth(String username, String password){
       for (UserManagement admin : AdminList) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                return  true;

            }
        }
        return  false;
    }

    public static void viewAllsers(){
       for (UserManagement user : UserList) {
                printUsers(user);
            }
            return;
        }


    public static void AddUser(UserManagement user){  
        UserList.add(user);
    }

    public static void DeleteUser(String username) {
        for (UserManagement user : UserList) {
            if(user.getUsername().equals(username)) {
                UserList.remove(user);
                System.out.println(user.getUsername() + " has been deleted");
                return;   
            }
		}
        System.out.println("User not found");
    }

    public void UpdateUser(String username) {
        for (UserManagement user : UserList) {
            if(user.getUsername().equals(username)) {
                System.out.println("Enter new username");
                username = Helper.readString("Enter new username");
                password = Helper.readString("Enter new password");
                email = Helper.readString("Enter new email");
                firstName = Helper.readString("Enter new firstName");
                lastName = Helper.readString("Enter new lastName");
                phoneNumber = Helper.readString("Enter new phoneNumber");

                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setphoneNumber(phoneNumber);
                user.setEmail(email);
                System.out.println("User updated");
            }
            
        }
    }
    
    public static void printUsers(UserManagement user){
        System.out.println("username: " +  user.getUsername());
        System.out.println("email: " +   user.getEmail());
        System.out.println("first name: " +  user.getFirstName() );
        System.out.println("last name: " +   user.getLastName());
        System.out.println("phone number: " +  user.getPhoneNumber());
        System.out.println("--------------------------------------");

    }

    public void setUser(String username, String password,String email,String firstName,String lastName, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		
	}

    
    
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    

}
