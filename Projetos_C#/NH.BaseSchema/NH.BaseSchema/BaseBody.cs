using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NH.BaseSchema
{
    public class BaseBody
    {
        public virtual Guid ID { get; set; }
        public BaseBody()
        {
        }

        public override string ToString()
        {
            string formato = "{0}[{1}] = {2}";
            StringBuilder sRet = new StringBuilder();
            sRet.AppendLine(string.Format(formato, "ID", this.ID.GetType(), this.ID));
            foreach (System.Reflection.PropertyInfo prop in this.GetType().GetProperties())
            {
                if (prop.Name != "ID")
                    sRet.AppendLine(string.Format(formato, prop.Name, prop.PropertyType, prop.GetValue(this, null)));
            }
            return sRet.ToString();
        }
    }
}
