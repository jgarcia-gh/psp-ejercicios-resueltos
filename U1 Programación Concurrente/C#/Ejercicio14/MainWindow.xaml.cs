using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ejercicio14
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        GestorFicheros gf = new GestorFicheros();

        public MainWindow()
        {
            InitializeComponent();
        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            label.Content = "Leyendo archivo";
            await gf.LeerArchivo(@".\ubuntu-24.04.1-desktop-amd64.iso", (f) => {
                Dispatcher.Invoke(() =>
                {
                    progressBar.Value = (int)f;
                });
            });
            label.Content = "Archivo leído";
        }
    }
}
