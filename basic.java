public class basic {
    public static void main(String[] arg){
        class Innerbasic {
            public void display() {
                System.out.println("Hello, this is an inner class method!");
            }
            class hint(){
                
            }
        }
        Innerbasic obj= new Innerbasic();
        obj.display();
    }
}
