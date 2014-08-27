package pattern.interpreter;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <h1>Interpreter Design Pattern</h1>
 * <p>Classe de test</p>
 *
 * On a utilisé ici la Reflexion Java.
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 01/08/2014
 * @version 1
 *
 * @see pattern.interpreter
 * @see ConversionContext
 * @see Expression
 */
public class MeasurementConversion {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        String questionAsked = JOptionPane.showInputDialog(frame, "What is your Question");

        ConversionContext question = new ConversionContext(questionAsked);

        String fromConversion = question.getFromConversion();
        String toConversion = question.getToConversion();
        double quantity = question.getQuantity();

        // Reflexion pour obtenir les différentes classes impliquées
        // Attention -> CHEMINEMENT INDIRECT (difficulté de compréhension à prévoir)
        try {

            // On identifie la classe qui s'occupera concrêtement de la conversion
            // Il s'agit d'une classe qui hérite d'Expression
            Class<?> tempClass = Class.forName("pattern.interpreter." + fromConversion);                // identification de la class
            Constructor<?> constructor = tempClass.getConstructor();           // on récupère le constructeur de cette classe
            Object convertFrom = (Expression) constructor.newInstance();    // on va créer une instance avec un cast (Expression)

            // On va ensuite identifier/préparer la méthode adéquate de cette instance
            Class<?>[] methodParams = new Class<?>[]{Double.TYPE};                // création d'un tableau de type de paramètre (un tableau de class)
            Method conversionMethod = tempClass.getMethod(toConversion, methodParams);      // identification de la méthode à utiliser (nom de la méthode = toConversion)
            Object[] params = new Object[]{new Double(quantity)};           // création du tableau d'objets contenant les paramètres

            // Lancement de la méthode avec invoke(instance concernée, paramètres de la méthode)
            String toQuantity = (String) conversionMethod.invoke(convertFrom, params);

            // Mise en place du résultat
            String answerToQues = question.getConversionReponse() + toQuantity + " " + toConversion;
            JOptionPane.showMessageDialog(null, answerToQues);
            frame.dispose();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
