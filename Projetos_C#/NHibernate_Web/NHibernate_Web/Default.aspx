<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="NHibernate_Web.Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .style1
        {
            width: 83px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <table style="width: 27%;">
            <tr>
                <td class="style1">
                    Nome:</td>
                <td>
                    <asp:TextBox ID="txt_nome" runat="server" Width="225px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style1">
                    Login:</td>
                <td>
                    <asp:TextBox ID="txt_login" runat="server" Width="153px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style1">
                    Senha:</td>
                <td>
                    <asp:TextBox ID="txt_senha" runat="server" Width="153px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style1">
                    Perfil:</td>
                <td>
                    <asp:TextBox ID="txt_perfil" runat="server" Width="153px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style1">
                    E-mail:</td>
                <td>
                    <asp:TextBox ID="txt_email" runat="server" Width="225px"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="style1">
                    &nbsp;</td>
                <td style="text-align: center">
                    <asp:Button ID="btn_Cadastrar" runat="server" Text="Cadastrar" 
                        onclick="btn_Cadastrar" />
                </td>
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>
