using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NHibernate;
using NHibernate.Cfg;

namespace NHibernate_Web
{
    public class NHibernateHelper
    {
        public static ISessionFactory _sessionFactory;

        public static ISessionFactory SessionFactory
        {
            get {
                if ((_sessionFactory == null)) {
                    Configuration configuration = new Configuration();
                    configuration.Configure();
                    configuration.AddAssembly(typeof(Usuario).Assembly);
                    _sessionFactory = configuration.BuildSessionFactory();
                }
                return _sessionFactory;
            }
        }

        public static ISession OpenSession()
        {
            return SessionFactory.OpenSession();
        }
    }
}
