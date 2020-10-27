using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ClassLibraryBusinessMyBikeBusLayer;
using ClassLibraryDataLayer;

namespace The_Presentation_Layer__Managing_the_stock_of_bikes
{
    public partial class Form1 : Form
    {
        List<Bike> bikeList = new List<Bike>();
        List<MountainBike> mountainBikeList = new List<MountainBike>();
        List<RoadBike> roadBikeList = new List<RoadBike>();

        int positionsuspensioncombo = -1;
        int positioncolorcombo = -1;
        int index = -1;//listbox
        private Bike SelectedBike;

        public Form1()
        {
            InitializeComponent();
        }
        private void BikeType_SelectedIndexChanged(object sender, EventArgs e)
        {
            ComboBox combo = (ComboBox)sender;
            SelectBikes(combo.Text);
        }
        private void SelectBikes(string bike)
        {
            if (bike.Equals("Mountain Bike"))
            {
                label7.Enabled = true;
                comboBoxSuspensionType.Enabled = true;
                textBoxSeatHeight.Enabled = false;
                textBoxWeight.Enabled = false;
                textBoxGroundHeight.Enabled = true;
                label24.Enabled = false;
            }
            else if (bike.Equals("Road Bike"))
            {
                label24.Enabled = true;
                comboBoxSuspensionType.Enabled = false;
                textBoxSeatHeight.Enabled = true;
                textBoxWeight.Enabled = true;
                textBoxGroundHeight.Enabled = false;
                label7.Enabled = false;
            }

        }
        private void Button_Add_Click(object sender, EventArgs e)
        {
            long serialNumber;
            double  warrenty , speed ,gheight, sheight,bweight;
            string make,input,msg="";
            EnumSuspension suspensionType;
            EnumColor color;
            bool correct = false;

            Bike mountainBike = null;
            Bike roadBike = null;
            //Bike bike;
            if (bikeType.SelectedIndex == -1)
            {
                MessageBox.Show("\t...BAD INPUT..No bike type selected\n");
                return;
            }

            input = textBoxSeialNumber.Text;
            correct = RegExValidator.Is12Digit(input) &&
                    RegExValidator.IsEmpty(input);
            if (!correct)
            {
                MessageBox.Show("\t...BAD INPUT..Serial cant be empty and should be of 12 digits\n");
                return;
            }
            serialNumber = long.Parse(input);
           

            correct = false;
            input = textBoxMake.Text;
            correct = RegExValidator.IsAlphabetLetter(input) &&
                    RegExValidator.IsEmpty(input);
            if (!correct)
            {
                MessageBox.Show("\t...BAD INPUT..Make cannot be empty and should contain\n");
                return;
            }
            make = input;
          
            correct = false;
            input = textBoxSpeed.Text;
           correct = RegExValidator.IsDigit(input) &&
                 RegExValidator.IsEmpty(input);
            if (!correct)
            {
                MessageBox.Show("\t...BAD INPUT..Speed cannot be empty and should contain only digits\n");
                return;
            }
            speed = Convert.ToDouble(input);
          
                
                Date made_date = new Date();
                made_date.Day = Convert.ToInt32(textBoxDay.Text);
                made_date.Month = Convert.ToInt32(textBoxMonth.Text);
                made_date.Year = Convert.ToInt32(textBoxYear.Text);
                suspensionType = (EnumSuspension)positionsuspensioncombo;
                color = (EnumColor)positioncolorcombo;
              
                warrenty = Convert.ToDouble(textBoxWarrenty.Text);
            if (bikeType.SelectedIndex == 1)
            {
                correct = false;
                input = textBoxSeatHeight.Text;
                correct = RegExValidator.IsDigit(input) &&
               RegExValidator.IsEmpty(input);
                if (!correct)
                {
                    MessageBox.Show("\t...BAD INPUT..Seat height cannot be empty and should contain only digits\n");
                    return;
                }
                sheight = Convert.ToDouble(input);
                bweight = Convert.ToDouble(textBoxWeight.Text);
                roadBike = new RoadBike(serialNumber, make, speed, color, made_date, warrenty,  sheight, bweight);
                bikeList.Add(roadBike);
             
                msg = "Bike successfully added as a road bike ";
            }
            else
            {
                gheight = Convert.ToDouble(textBoxGroundHeight.Text);
                mountainBike = new MountainBike(serialNumber, make, speed, color, made_date, warrenty,  gheight, suspensionType);
                bikeList.Add(mountainBike);
              
                msg = "Bike successfully added as a mountain bike ";
            }

        
            msg += "with bikelist";
            MessageBox.Show(msg);

        }
        

        private void Form1_Load(object sender, EventArgs e)
        {
            foreach (EnumSuspension susType in Enum.GetValues(typeof(EnumSuspension)))
            {
                this.comboBoxSuspensionType.Items.Add(susType);
            }
            this.comboBoxSuspensionType.Text = Convert.ToString(EnumSuspension.Front);
            foreach (EnumColor color in Enum.GetValues(typeof(EnumColor)))
            {
                this.comboBoxColor.Items.Add(color);
            }
            this.comboBoxColor.Text = Convert.ToString(EnumColor.White);
           this.bikeType.Items.Add("Mountain Bike");
           this.bikeType.Items.Add("Road Bike");
           comboBoxSuspensionType.Enabled = false;
            textBoxSeatHeight.Enabled = false;
            textBoxGroundHeight.Enabled = false;
            textBoxWeight.Enabled = false;
            this.bikeType.Focus();
        }

        private void Button_Update_Click(object sender, EventArgs e)
        {
            int indexInBikes = GetIndexOfInList(SelectedBike,
                BikeToObject(bikeList));
            int indexInType = -1;
            Bike newObj;
            if (SelectedBike is RoadBike)
            {
                indexInType = GetIndexOfInList(SelectedBike, RoadBikeToObject(roadBikeList));
                newObj = new RoadBike(long.Parse(textBoxSeialNumber.Text), textBoxMake.Text,
                    Convert.ToDouble(textBoxSpeed.Text), (EnumColor)Enum.Parse(typeof(EnumColor),
                    comboBoxColor.Text),
                    new Date(Convert.ToInt32(textBoxDay.Text), Convert.ToInt32(textBoxMonth.Text),
                    Convert.ToInt32(textBoxYear.Text)), Convert.ToInt32(textBoxWarrenty.Text), Convert.ToInt32(textBoxSeatHeight.Text), Convert.ToDouble(textBoxWeight.Text));
                roadBikeList.RemoveAt(indexInType);
                roadBikeList.Insert(indexInType, (RoadBike)newObj);
            }
            else 
            {
                indexInType = GetIndexOfInList(SelectedBike, MountainBikeToObject(mountainBikeList));
                newObj = new MountainBike(long.Parse(textBoxSeialNumber.Text), textBoxMake.Text,
                    Convert.ToDouble(textBoxSpeed.Text), (EnumColor)Enum.Parse(typeof(EnumColor),
                    comboBoxColor.Text),
                    new Date(Convert.ToInt32(textBoxDay.Text), Convert.ToInt32(textBoxMonth.Text),
                    Convert.ToInt32(textBoxYear.Text)), Convert.ToInt32(textBoxWarrenty.Text), Convert.ToDouble(textBoxGroundHeight.Text),
                    (EnumSuspension)Enum.Parse(typeof(EnumSuspension), comboBoxSuspensionType.Text));
                mountainBikeList.RemoveAt(indexInType);
                mountainBikeList.Insert(indexInType, (MountainBike)newObj);
            }
            bikeList.RemoveAt(indexInBikes);
            bikeList.Insert(indexInBikes, newObj);
            if (indexInBikes == -1 || indexInType == -1 || newObj == null)
                MessageBox.Show("Could not Update!");
            else
                MessageBox.Show("Updated successfully!");
        }

        private void Button_Remove_Click(object sender, EventArgs e)
        {
            DialogResult result;
            result = MessageBox.Show("Do you want to delete this bike? ", "Delete",
                MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes && index >= 0)
            {
                index = this.listBoxDisplay.SelectedIndex;
                MessageBox.Show("Bike " + this.bikeList[index].SerialNumber + " Removed");
                this.bikeList.RemoveAt(index);
                this.mountainBikeList.RemoveAt(index);
                this.roadBikeList.RemoveAt(index);
            }
            else if (result == DialogResult.No)
            {
                MessageBox.Show("Bike Serial Number " + this.bikeList[index].SerialNumber + " NOT Removed");
            }
        }

        private void Button_Reset_Click(object sender, EventArgs e)
        {
            foreach (Control aControl in Controls)
            {
                if (aControl is TextBox)
                {
                    aControl.Text = "";
                }
            }
            this.listBoxDisplay.Items.Clear();
            this.comboBoxSuspensionType.Text = Convert.ToString(EnumSuspension.Front);
            this.comboBoxColor.Text = Convert.ToString(EnumColor.White);
            this.textBoxGroundHeight.Enabled = true;
            this.textBoxSeatHeight.Enabled = true;
            this.button_Add.Enabled = true;
            this.textBoxSeialNumber.Enabled = true;
            this.textBoxGroundHeight.Text = "";
        }

        private void Button_Write_Click(object sender, EventArgs e)
        {
            FileHandler.WriteToFile(bikeList);
            MessageBox.Show("Content added");
        }

        private void Button_Read_Click(object sender, EventArgs e)
        {
            if (File.Exists(FileHandler.filePath))
            {
                List<Bike> listFromFile = new List<Bike>();

                listFromFile = FileHandler.ReadFromFile();

                bikeList = listFromFile;
                listBoxDisplay.Items.Add(listFromFile);

                MessageBox.Show("Content loaded");
            }
            else
            {
                MessageBox.Show("No data found");
            }
        }

        private void Button_DisplayAllBike_Click(object sender, EventArgs e)
        {
            this.listBoxDisplay.Items.Clear();
            if (bikeList.Count > 0)
            {
                foreach (Bike element in bikeList)
                {
                    listBoxDisplay.Items.Add(element);
                }
            }
            else
            {
                MessageBox.Show("\n" + "NO DATA...The list is empty");
            }
        }

       

        private void Button_roadbike_Click(object sender, EventArgs e)
        {
            this.listBoxDisplay.Items.Clear();
            foreach (Bike element in bikeList)
            {
                if (element is RoadBike)
                {
                    roadBikeList.Add((RoadBike)element);
                }
            }

            if (roadBikeList.Count > 0)
            {
                foreach (RoadBike element in roadBikeList)
                {
                    listBoxDisplay.Items.Add(element);
                }
            }
            else
            {
                MessageBox.Show("\n" + "NO DATA...The list is empty");
            }
        }
        private void Button_Exit_Click(object sender, EventArgs e)
        {
            DialogResult result;
            result = MessageBox.Show("Do you want to exit? ", "Exit",
                MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
            if (result == DialogResult.OK)
            {
                this.Close();
            }
        }

        private void Button_mountainbike_Click(object sender, EventArgs e)
        {
            this.listBoxDisplay.Items.Clear();
           foreach (Bike element in bikeList)
            {
                if (element is MountainBike)
                {
                    mountainBikeList.Add((MountainBike)element);
                }
            }
            if (mountainBikeList.Count > 0)
            {
                foreach (MountainBike element in mountainBikeList)
                {
                    listBoxDisplay.Items.Add(element);
                }
            }
            else
            {
                MessageBox.Show("\n" + "NO DATA...The list is empty");
            }
        }

        private void ListBoxDisplay_SelectedIndexChanged(object sender, EventArgs e)
        {
            index = this.listBoxDisplay.SelectedIndex;
            if (index >= 0)
            {
                ListBox combo = (ListBox)sender;

                foreach (var items in listBoxDisplay.SelectedItems)
                {
                    showBike((Bike)items);
                   SelectedBike = (Bike)items;
                }
            }
        }
        private void showBike(Bike bike)
        {
            string[] bikeAttr = bike.ToString().Split('\t');
            textBoxSeialNumber.Text = bikeAttr[0];
            textBoxMake.Text = bikeAttr[1];
            textBoxSpeed.Text = bikeAttr[3];
            comboBoxColor.Text = bikeAttr[5];
       
            textBoxWarrenty.Text = bikeAttr[7];
            string[] bikeDateAttr = bikeAttr[9].Split('/');
            textBoxDay.Text = bikeDateAttr[0];
            textBoxMonth.Text = bikeDateAttr[1];
            textBoxYear.Text = bikeDateAttr[2];
 

            if (bike is RoadBike)
            {
                textBoxSeatHeight.Text = bikeAttr[11];
                textBoxWeight.Text = bikeAttr[13];
                bikeType.Text = "Road Bike";
                if (textBoxSeatHeight.Enabled == false)
                    SelectBikes("Road Bike");
            }
            else if (bike is MountainBike)
            {
                comboBoxSuspensionType.Text = bikeAttr[15];
               textBoxGroundHeight.Text = bikeAttr[17];
              
                  bikeType.Text= "Mountain Bike";
                if (comboBoxSuspensionType.Enabled == false)
                SelectBikes("Mountain Bike");
            }
        }
        private int GetIndexOfInList(Bike inptBike, List<Object> inptList)
        {
            int indx = -1;
            for (int i = 0; i < inptList.Count; i++)
                if (inptList[i].ToString().Equals(inptBike.ToString()))
                    indx = i;
            return indx;
        }

        private List<Object> BikeToObject(List<Bike> bikes)
        {
            List<Object> objList = new List<Object>();
            foreach (Bike itrBike in bikes)
                objList.Add((object)itrBike);
            return objList;
        }

        private List<Object> RoadBikeToObject(List<RoadBike> rBikes)
        {
            List<Object> objList = new List<Object>();
            foreach (Bike itrBike in rBikes)
                objList.Add((object)itrBike);
            return objList;
        }

        private List<Object> MountainBikeToObject(List<MountainBike> mBikes)
        {
            List<Object> objList = new List<Object>();
            foreach (Bike itrBike in mBikes)
                objList.Add((object)itrBike);
            return objList;
        }
        private void ComboBoxSuspensionType_SelectedIndexChanged(object sender, EventArgs e)
        {
            positionsuspensioncombo = this.comboBoxSuspensionType.SelectedIndex;
        }

        private void ComboBoxColor_SelectedIndexChanged(object sender, EventArgs e)
        {
            positioncolorcombo = this.comboBoxColor.SelectedIndex;
        }

        private void Button_Search_Click(object sender, EventArgs e)
        {
            if (textBoxSeialNumber.Text.Equals("") ||
                !RegExValidator.Is12Digit(textBoxSeialNumber.Text))
            {
                MessageBox.Show("Not a valid serial number");
                return;
            }
            Boolean found = false;
            listBoxDisplay.Items.Clear();
            if (bikeList.Count > 0)
            {
                foreach (Bike bike in bikeList)
                {
                    if (bike.SerialNumber.Equals(long.Parse(textBoxSearchBike.Text)))
                    {
                        listBoxDisplay.Items.Add(bike);
                        found = true;
                        MessageBox.Show("Bike found, Details are shown in list box");
                    }
                }
            }
            else
            {
                MessageBox.Show("\n" + "NO DATA...The list is empty");
            }
            if (!found)
                MessageBox.Show("No Search Results..!!");
        }

        private void TextBoxPrice_TextChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }
    }
}
