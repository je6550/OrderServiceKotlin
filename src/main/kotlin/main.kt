import java.util.*;
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val sc = Scanner(System. `in`)
    println("Welcome to the shopping service")
    println("The cost of an Apple is $0.60 and the cost of an Orange is $0.25")
    println("Enter the list of items from either Apples or Oranges")
    println("Enter 'Done' after placing orders")
    val inputList = arrayListOf<String>()
    while(sc.hasNext()){
        var temp = sc.next()
        if(temp== "done" || temp == "Done"){
            break;
        }
        inputList.add(sc.next())
    }

    ShoppingService(inputList).totalCost(inputList)
}

class ShoppingService(itemList: ArrayList<String>)
{
    fun totalCost(itemList : ArrayList<String>) : Double{
        val stock = arrayOf<Int>(0,0)
        stock[0] = 25
        stock[1] = 25
        var cost : Double = 0.0;
        var apple = 0
        var orange = 0
        for(i in itemList){
            if (i == "Apple" || i == "apple"){
                cost += 0.60
                apple++
            }
            else if(i == "Orange" || i == "orange"){
                cost += 0.25
                orange++
            }
        }
        apple *= 2
        var totalOranges = orange+orange/2

        if(apple > stock[0]){
            println("Apples out of stock")
            MailService().orderIncompleteListener()
            return 0.0;
        }
        if(orange > stock[1]){
            println("Oranges out of stock")
            MailService().orderIncompleteListener()
            return 0.0;
        }

        println("You will get $apple apples and $totalOranges oranges")
        println("The total cost of your oder is $ $cost")
        MailService().orderCompleteListener()
        return cost

    }
}

class MailService(){
    fun orderCompleteListener(){
        println("Your order is completed. The delievery will be done within 24 hours. :)")
    }

    fun orderIncompleteListener(){
        println("Sorry, the order was not completed. Please try again. :(")
    }
}