import java.util.Scanner;
class mainfile
{
	public static void main(String[] args)
	{
		companynode ceo=new companynode();
		Scanner s = new Scanner(System.in);
		avl tree=new avl();
		System.out.println("********************* WELCOME TO THE COMPANY *********************");
		int option=0;
		String empname1=new String();
		String empname2=new String();
		
//root deepak
		tree.root=new node();
		tree.root.key="Deepak";
		tree.root.link=new companynode();
		tree.root.link.level=1;
		tree.root.link.name="Deepak";
		tree.root.height=0;
		ceo=tree.root.link;
//others
	   try{
		tree.insert("Anuj",tree.search("Deepak"));
		tree.insert("Abhishek",tree.search("Anuj"));
		tree.insert("Saurabh",tree.search("Anuj"));
		tree.insert("Alok",tree.search("Anuj"));
		tree.insert("Mukesh",tree.search("Saurabh"));
		tree.insert("Vineet",tree.search("Saurabh"));
		tree.insert("Utkarsh",tree.search("Saurabh"));
		tree.insert("Ojasvi",tree.search("Abhishek"));
		tree.insert("Rohan",tree.search("Abhishek"));
		tree.insert("Jessica",tree.search("Deepak"));
		tree.insert("Harvey",tree.search("Jessica"));
		tree.insert("Louis",tree.search("Jessica"));
		tree.insert("Mike",tree.search("Harvey"));
		tree.insert("Dona",tree.search("Harvey"));
		tree.insert("Rachel",tree.search("Dona"));
		tree.insert("Trent",tree.search("Louis"));
		tree.insert("Norma",tree.search("Louis"));
		tree.insert("Sheldon",tree.search("Deepak"));
		tree.insert("Alex",tree.search("Sheldon"));
		tree.insert("Amy",tree.search("Sheldon"));
		tree.insert("Leonard",tree.search("Sheldon"));
		tree.insert("Leslie",tree.search("Sheldon"));
		tree.insert("Raj",tree.search("Leonard"));
		tree.insert("Wolowitz",tree.search("Raj"));
		tree.insert("Penny",tree.search("Wolowitz"));
		tree.insert("Stuart",tree.search("Raj"));
	   }
	   catch(NoSuchEmployeeFoundException e){}
	   catch(DuplicateException e){}
	   catch(InvalidInput e){}


		do
		{
			System.out.println("\n\n\tMENU:");
			System.out.println("\t\t1. Add Employee");
			System.out.println("\t\t2. Remove Employee");
			System.out.println("\t\t3. Find lowest common bosses of two employees");
			System.out.println("\t\t4. Print Employees");
			System.out.println("\t\t5. Exit");
			System.out.println("\nEnter your choice (1 - 5) : ");
			option=s.nextInt();
			switch(option)
			{
				case 1:		if(tree.root.key==null || tree.root==null)
						{
							tree.root=new node();
							System.out.println("Enter the name of the CEO : ");
							empname1=s.next();
							tree.root.key=empname1;
							tree.root.link=new companynode();
							tree.root.link.level=1;
							tree.root.link.name=empname1;
							tree.root.height=0;
							ceo=tree.root.link;
						}
						else
						{
							System.out.println("Enter the name of the employee under whom you want to add the employee");
							String bossname = new String();
							bossname=s.next();
							System.out.println("\nEnter the name of the new employee");
							empname1=s.next();
							node b = new node();
							try
							{
								b=tree.search(bossname);
								tree.insert(empname1,b);
							}
							catch(NoSuchEmployeeFoundException e){}
							catch(DuplicateException e){}
							catch(InvalidInput e){}
						}
						break;
				case 2:		System.out.println("Enter the name of the employee to be removed");
						empname1=s.next();
						System.out.println("Enter the name of the second employee on the same level under which the juniors of the removed employee must go");
						empname2=s.next();
						try
						{
							tree.delete(empname1,tree.search(empname2));
						}
						catch(NoSuchEmployeeFoundException e){}
						catch(NotAtSameLevelException e)
						{
							System.err.println("\nThe other employee must be of the same level.\n");
						}
						catch(InvalidInput e){}
						break;
				case 3:		System.out.println("Enter the name of first employee");
						empname1=s.next();
						System.out.println("Enter the name of second employee");
						empname2=s.next();
						try
						{
							tree.lowestcommonboss(tree.search(empname1).link,tree.search(empname2).link);
						}
						catch(NoSuchEmployeeFoundException e){}
						catch(InvalidInput e){}
						break;
				case 4:		ceo.printlist();		
						break;
				case 5:		break;
				default:	System.out.println("Wrong input value");
			}
		}while(option!=5);
	}
}
