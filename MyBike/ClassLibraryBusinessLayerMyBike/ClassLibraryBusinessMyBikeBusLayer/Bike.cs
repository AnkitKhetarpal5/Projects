using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibraryBusinessMyBikeBusLayer
{
    [Serializable]
    public abstract class Bike:IMovable
    {
        private long serialNumber;
        protected string make;
        protected double speed;
        protected EnumColor color;
        protected Date manufdate;
        protected double warrentyYear;
       

        public long SerialNumber { get => serialNumber; set => serialNumber = value; }
        public Bike()
        {
            this.serialNumber = 0;
        }

        public Bike(long serialNumber, string make, double speed, EnumColor color, Date manuDate,double warrentyYear)
        {
            this.serialNumber = serialNumber;
            this.make = make;
            this.speed = speed;
            this.color = color;
            this.manufdate = manuDate;
            this.warrentyYear = warrentyYear;
          
        }

        public virtual double GetMaxSpeed()
        {
            return this.speed = 20.00;
        }

        public abstract void SpeedUp(double newSpeed);
   

        public override string ToString()
        {
            return SerialNumber +
               "\t" + make +
               "\t\t" + speed +
               "\t\t" + color +  "\t\t" + warrentyYear +
               "\t\t" + manufdate.ToString();
        }
    }
}
