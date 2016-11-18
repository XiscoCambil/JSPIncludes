import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dcatalans on 15/11/16.
 */
public class FileManagment{
    private String dir;
    private String path;
    private String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void constructPath(){

    }

    public void createDirectory(){
        File theDir = new File(path+"/"+name+"/");

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory...");
            boolean result = false;
            try{
                theDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
                System.out.println("SecurityException");
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
        else{
            System.out.println("El directorio ya existe");
        }
    }

    public boolean isExist(){
        File complet_file = new File(this.path+"/"+this.name);
        if (complet_file.exists()){
            return true;
        }
        return false;
    }

 public List<File> directoryTree() {
     File[] f = new File(path+"/"+name+"/").listFiles();
     List<File> files = new ArrayList<File>();
     for (int i = 0; i < f.length; i++) {
         files.add(f[i]);
     }
        return files;
    }

    //Esto tal vez se pase a un Servlet
    public void printTree(File dir){
        File[] listFile = dir.listFiles();
        if(listFile != null){
            for (int i=0; i<listFile.length; i++) {
                if (listFile[i].isDirectory()) {
                    System.out.println("|\t\t");
                        printTree(listFile[i]);
                } else {
                    System.out.println("+---"+listFile[i].getName().toString());

                }
            }
        }

    }
}
