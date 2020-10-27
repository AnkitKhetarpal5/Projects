using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibraryBusinessMyBikeBusLayer
{
   public class MountainBike: Bike
    {
        private double groundHeight;
        private EnumSuspension suspensionType;
       
        public double GroundHeight { get => groundHeight; set => groundHeight = value; }
        public EnumSuspension SuspensionType { get => suspensionType; set => suspensionType = value; }
         public MountainBike() : base()
        {
            this.groundHeight = 0.0;
            this.suspensionType = EnumSuspension.Front;
        }
        public MountainBike(long serialNumber, string make, double speed, EnumColor color, Date madeDate, double warrentyYear,double groundHeight, EnumSuspension suspensionType) : base(serialNumber, make, speed, color, madeDate,warrentyYear)
        {
            this.groundHeight = groundHeight;
            this.suspensionType = suspensionType;
        }
        public override void SpeedUp(double newSpeed)
        {
            if ((speed + newSpeed) < GetMaxSpeed())
            {
                speed += newSpeed;
            }
        }

        public override string ToString()
        {
            return base.ToString() + "\t\t-\t\t" + suspensionType + "\t\t" + groundHeight ;
            
        }

       
    }
}
