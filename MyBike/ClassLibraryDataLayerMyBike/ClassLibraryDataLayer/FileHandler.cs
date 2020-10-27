using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading.Tasks;
using ClassLibraryBusinessMyBikeBusLayer;

namespace ClassLibraryDataLayer
{
    public class FileHandler
    {
        public static string filePath = @"../../my_bikes.ser";

        public static void WriteToFile(List<Bike> bikelist)
        {
            FileStream fs = new FileStream(filePath, FileMode.OpenOrCreate, FileAccess.Write);
            BinaryFormatter bf = new BinaryFormatter();
     
                bf.Serialize(fs, bikelist);
            fs.Close();
        }
        public static List<Bike> ReadFromFile()
        {
            List<Bike> list = new List<Bike>();
            FileStream fs = new FileStream(filePath, FileMode.Open, FileAccess.Read);
            BinaryFormatter bf = new BinaryFormatter();
            if (File.Exists(filePath))
            {

                list = (List<Bike>)bf.Deserialize(fs);  

                fs.Close(); //close the pipe
            }
            return list;
           
        }
    }
}
