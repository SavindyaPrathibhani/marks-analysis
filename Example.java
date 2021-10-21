import java.util.*;
class Example{
	//Recommend reseeding within methods
	public static int stCount=0;
	
	static Scanner input=new Scanner(System.in);
	
	public static void menu(String[] stId, String[] stName, int[][] marks){
		
		clearConsole();
		System.out.println(" ---------------------------------------------------------------------------------");
		System.out.println("|                    WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                      |");
		System.out.println(" ---------------------------------------------------------------------------------\n");
		
		System.out.print("[1] Add New Student\t\t\t ");
		System.out.print("[2] Add New Student With Marks\n");
		System.out.print("[3] Add Marks\t\t\t\t ");
		System.out.print("[4] Update Student Details\n");
		System.out.print("[5] Update Marks\t\t\t ");
		System.out.print("[6] Delete Student\n");
		System.out.print("[7] Print Student Details\t\t ");
		System.out.print("[8] Print Student Ranks\n");
		System.out.print("[9] Best in Programming Fundamentals\t ");
		System.out.print("[10] Best in Database Management System\n");
		
		System.out.print("\nEnter an option to continue > ");
		int option=input.nextInt();
		
		if(option==1){
			addNewStudent(stId,stName,marks);
		}
	    if(option==2){
			addNewStudentWithMarks(stId,stName,marks);
		}
		if(option==3){
			addMarks(stId,stName,marks);
		}
		if(option==4){
		
			updateStudentDetails(stId,stName,marks);
		}
		if(option==5){
			updateMarks(stId,stName,marks);
		}
		if(option==6){
			deleteStudent(stId,stName,marks);
		}
		if(option==7){
			printStudentDetails(stId,stName,marks);
		}
		if(option==8){
			printStudentRanks(stId,stName,marks);
		}
		if(option==9){
			bestInPRF(stId,stName,marks);
		}
		if(option==10){
			bestInDBMS(stId,stName,marks);
		}
	
	}
	
	public static void addNewStudent(String[] stId, String[] stName, int[][] marks){
		
		
			clearConsole();
		
		System.out.println(" -----------------------------------------------------------------");
		System.out.println("|                       ADD NEW STUDENT                           |");
		System.out.println(" -----------------------------------------------------------------\n");
		
	 		
		 
      L1:   for(int i = stCount; i <= stId.length; i++){
	          if(stCount<stId.length){ 
			
		      System.out.print("Enter Student ID   : ");
			  String temp=input.next();
			  if(temp.length()>=4){
			  String sub = temp.substring(0, 3);
              String remainder=temp.substring(3);
              
              boolean b=isInteger(remainder);
              
                if(sub.equals("S00")&& b==true  ) {
                    stId[i]= temp;
                    
               
		        }else{
					i--;
				  	System.out.println("Invalid id !\n");
				    continue L1;
				     }
             }else{
				  i--;
				  System.out.println("Invalid id !\n");
				  continue L1;
				  }
          L2:   for (int j = 0; j < i; j++){
              	 if (stId[i].equals(stId[j])){
					 System.out.println("The Student ID already exists\n");
                    i--;
                    
                   continue L1;
                 }
             }
             
             
             System.out.print("Enter Student Name : ");
             stName[i]= input.next();
             stCount++; 
             
             System.out.print("\nStudent has been added successfully. Do you want to add a new student (y/n) ");
             char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName, marks);
				 break;
				 }
				 	clearConsole();
				 	
		System.out.println(" -----------------------------------------------------------------");
		System.out.println("|                       ADD NEW STUDENT                           |");
		System.out.println(" -----------------------------------------------------------------\n");
		
		  }else{
	            String[] newStId=new String[stId.length+1];
	            String[] newStName=new String[stName.length+1];
	            int[][] newMarks=new int[marks.length+1][2];
	
	           for(int k=0; k<stId.length; k++){
		        newStId[k]=stId[k];
		        newStName[k]=stName[k];
		        newMarks[k]=marks[k];
		       }
	           stId=newStId;
	           stName=newStName;
	           marks=newMarks;
	           i--;
	           continue L1;
             }
		
       }
  
}
 
			
	public static void addNewStudentWithMarks(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                      ADD NEW STUDENT WITH MARKS                       |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		L1:   for(int i = stCount; i <= stId.length; i++){
	          if(stCount<stId.length){ 
			
		      System.out.print("Enter Student ID   : ");
			  String temp=input.next();
			  if(temp.length()>=4){
			  String sub = temp.substring(0, 3);
              String remainder=temp.substring(3);
              
              boolean b=isInteger(remainder);
              
                if(sub.equals("S00")&& b==true  ) {
                    stId[i]= temp;
                    
		        }else{
					i--;
				  	System.out.println("Invalid id !\n");
				    continue L1;
				     }
             }else{
				  i--;
				  System.out.println("Invalid id !\n");
				  continue L1;
				  }
          L2:   for (int j = 0; j < i; j++){
              	 if (stId[i].equals(stId[j])){
					 System.out.println("The Student ID Already exists\n");
                    i--;
                    
                   continue L1;
                 }
             }
             
             
             System.out.print("Enter Student Name : ");
             stName[i]= input.next();
             
         L3:    for(int m=0; ; m++){
                 System.out.print("Programming Fundamentals Marks : ");
                 int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                 marks[i][0]=temp2;
                 break ;
			     }else{
					 System.out.println("Invalid marks! please enter correct marks. ");
					 }
		     }  
		 L4:    for(int m=0; ; m++){  
                System.out.print("Database Management Systems Marks : "); 
                int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                marks[i][1]=temp2;
                break ;
			     }else{
					 System.out.println("Invalid marks! please enter correct marks. ");
					 }
		     }
             
             stCount++;
             
             System.out.print("\nStudent has been added successfully. Do you want to add a new student (y/n) ");
             char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break;
				 }
				 	clearConsole();
				 	
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                      ADD NEW STUDENT WITH MARKS                       |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		
		  }else{
	            String[] newStId=new String[stId.length+1];
	            String[] newStName=new String[stName.length+1];
	            int[][] newMarks=new int[marks.length+1][2];
	
	              for(int k=0; k<stId.length; k++){
		             newStId[k]=stId[k];
		             newStName[k]=stName[k];
		             newMarks[k]=marks[k];
		          }
	           stId=newStId;
	           stName=newStName;
	           marks=newMarks;
	           i--;
	           continue L1;
               }
		
          }
  
  }
 
		
	public static void addMarks(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                              ADD MARKS                                |");
		System.out.println(" -----------------------------------------------------------------------\n");
		  int i;
	L1:	 for(int j=0; ; j++){
	      System.out.print("Enter student id : ");
	      String temp=input.next();
	        int stIndex=-1;
	  L2:    for( i=0; i<stCount; i++){
			 if(temp.equals(stId[i])){
				  stIndex=i;
				  break;
				 }
				
			  }
			 if(stIndex==-1){
				 
				 System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
				 char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 j--;
					 continue L1;
					 }
				
			 }
			 System.out.println("Student Name : "+stName[i]);
			 
			 if(marks[i][0]==0 && marks[i][1]==0){
				 
				 
		  L3:    for(int m=0; ; m++){
                 System.out.print("Programming Fundamentals Marks : ");
                 int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                 marks[i][0]=temp2;
                 break ;
			     }else{
					 System.out.println("Invalid marks !");
					 }
		     }  
		 L4:    for(int m=0; ; m++){  
                System.out.print("Database Management Systems Marks : "); 
                int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                marks[i][1]=temp2;
                break ;
			     }else{
					 System.out.println("Invalid marks !");
					 }
		     }
				 
				 
				 
				 
				 }else{
					 System.out.println("This student's marks have been already added.\nIf you want to update the marks, please use [5] Update Marks option. ");
					 System.out.print("\nDo you want to add marks for another student? (y/n) ");
					  char c1=input.next().charAt(0);
             
                       if(c1=='n'){
				          menu(stId,stName,marks);
				          break L1;
				        }
				        
				        continue L1;  
					 }
			  System.out.print("\nMarks have been added. Do you want to add marks for another student? (y/n)");
			  char c1=input.next().charAt(0);
             
                       if(c1=='n'){
				          menu(stId,stName,marks);
				           break L1;
				        }
				 clearConsole(); 
				 System.out.println(" -----------------------------------------------------------------------");
		         System.out.println("|                              ADD MARKS                                |");
		         System.out.println(" -----------------------------------------------------------------------\n");      
		 } 
	}
	public static void updateStudentDetails(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                       UPDATE STUDENT DETAILS                          |");
		System.out.println(" -----------------------------------------------------------------------\n");
		    int i;
	L1:	 for(int j=0; ; j++){
	      System.out.print("\nEnter student id : ");
	      String temp=input.next();
	        int stIndex=-1;
	  L2:    for( i=0; i<stCount; i++){
			 if(temp.equals(stId[i])){
				  stIndex=i;
				  break;
				 }
				
			  }
			 if(stIndex==-1){
				 
				 System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
				 char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 j--;
					 continue L1;
					 }
				
			 }
			 System.out.println("Student Name : "+stName[i]);
			 System.out.print("Enter the new student name : ");
			 stName[i]=input.next();
			 
			 System.out.print("\nStudent details has been updated successfully. \nDo you want to update another student detail? (y/n) ");
             char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName, marks);
				 break;
				 }
				 
				 clearConsole(); 
				 System.out.println(" -----------------------------------------------------------------------");
		         System.out.println("|                     UPDATE STUDENT DETAILS                            |");
		         System.out.println(" -----------------------------------------------------------------------\n");      
		 } 
		
	
		}
	
	public static void updateMarks(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                              UPDATE MARKS                             |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		int i;
	L1:	 for(int j=0; ; j++){
	      System.out.print("Enter student id : ");
	      String temp=input.next();
	        int stIndex=-1;
	  L2:    for( i=0; i<stCount; i++){
			 if(temp.equals(stId[i])){
				  stIndex=i;
				  break;
				 }
				
			  }
			 if(stIndex==-1){
				 
				 System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
				 char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 j--;
					 continue L1;
					 }
				
			 }
			 System.out.println("Student Name : "+stName[i]);
			 
			 if(marks[i][0]!=0 && marks[i][1]!=0){
			 
			 System.out.println("Programming Fundamentals Marks   : "+marks[i][0]);
			 System.out.println("Database Management System Marks : "+marks[i][1]);
			 
			 L3:    for(int m=0; ; m++){
                 System.out.print("\nEnter new Programming Fundamentals Marks : ");
                 int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                 marks[i][0]=temp2;
                 break ;
			     }else{
					 System.out.println("Invalid marks !");
					 }
		     }  
		 L4:    for(int m=0; ; m++){  
                System.out.print("Enter new Database Management Systems Marks : "); 
                int temp2=input.nextInt(); 
                 if(temp2>=0 && temp2<=100){
                marks[i][1]=temp2;
                break ;
			     }else{
					 System.out.println("Invalid marks !");
					 }
		     }
			  System.out.print("\nMarks have been updated successfully.\nDo you want to update marks for another student? (y/n) ");
              char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName, marks);
				 break;
				 }
		  }else{
			  System.out.println("This student's marks yet to be added.");
			  System.out.print("Do you want to update the marks of another student? (y/n) ");
			  char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName, marks);
				 break;
				 }
			  }
				 clearConsole(); 
				 System.out.println(" -----------------------------------------------------------------------");
		         System.out.println("|                              UPDATE MARKS                             |");
		         System.out.println(" -----------------------------------------------------------------------\n");
		 } 
		
		}
	public static void deleteStudent(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                            DELETE STUDENT                             |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		int i;
	L1:	 for(int j=0; ; j++){
	      System.out.print("Enter student id : ");
	      String temp=input.next();
	        int stIndex=-1;
	  L2:    for( i=0; i<stCount; i++){
			 if(temp.equals(stId[i])){
				  stIndex=i;
				  break;
				 }
				
			  }
			 if(stIndex==-1){
				 
				 System.out.print("Invalid Student ID. Do you want to search again? (y/n) ");
				 char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 j--;
					 continue L1;
					 }
				}
				
				String[] newStId=new String[stId.length-1];
	            String[] newStName=new String[stName.length-1];
	            int[][] newMarks=new int[marks.length-1][2];
	            
	            stCount--;
	            
	            for(int k=0; k<i; k++ ){
					newStId[k]=stId[k];
					newStName[k]=stName[k];
					newMarks[k]=marks[k];
					}
	            
	            for(int k=i; k<stCount; k++ ){
					newStId[k]=stId[k+1];
					newStName[k]=stName[k+1];
					newMarks[k]=marks[k+1];
					}
	            
	            stId=newStId;
	            stName=newStName;
	            marks=newMarks;
	            
				System.out.println("Student has been deleted successfully.");
				System.out.print("Do you want to delete another student? (y/n) ");
				char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 j--;
					 continue L1;
					 }
			 }
		}	
	public static void printStudentDetails(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                        PRINT STUDENT DETAILS                          |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		 int i;
	L1:	 for(int j=0; ; j++){
	      System.out.print("\nEnter student id : ");
	      String temp=input.next();
	        int stIndex=-1;
	  L2:    for( i=0; i<stCount; i++){
			 if(temp.equals(stId[i])){
				  stIndex=i;
				  break;
				 }
				
			  }
			 if(stIndex==-1){
				 
				 System.out.print("Invalid Student ID.Do you want to search another student details? (y/n) ");
				 char c1=input.next().charAt(0);
             
             if(c1=='n'){
				 menu(stId,stName,marks);
				 break L1;
				 }else{
					 continue L1;
					 }
			 }
			 
			int[] total=new int[stCount];
			double[] avg=new double[stCount];
			
			for(int k=0; k<total.length; k++){
				total[k]=marks[k][0]+marks[k][1];
				}
			for(int k=0; k<total.length; k++){
				avg[k]=total[k]/2.0;
				Math.round((avg[k]*100.00)/100.00);
				}
			sort(total);
			
			int rank=0;
			
			for(int k=0; k<total.length;k++){
				if((marks[i][0]+marks[i][1])==total[k]){
					rank=k+1;
					break;
					}
			}
			String place;
			if(rank==stCount){
				place="(Last)  ";
				}else{
					place="        ";
					}
			switch(rank){
				case 1: place="(First) ";break;
				case 2: place="(Second)";break;
				case 3: place="(Third) ";break;
				
				}
			
		    System.out.println("Student Name     : "+stName[i]);
		   
			
			if(marks[i][0]!=0 && marks[i][1]!=0){
			  System.out.println("+------------------------------------+--------------+");
				System.out.print("|Programming Fundamental Marks       |\t "+marks[i][0]+" \t    |");
			  System.out.print("\n|Database Management System Marks    |\t "+marks[i][1]+"   \t    |");
			  System.out.print("\n|Total Marks                         |\t "+(marks[i][0]+marks[i][1])+"   \t    |");
			  System.out.print("\n|Avg Marks                           |\t "+avg[i]+" \t    |");
			System.out.println("\n|Rank                                |\t "+rank+place+"  |");
			  System.out.println("+------------------------------------+--------------+");
				}else{
					System.out.println("\nThis student's marks yet to be added.");
			        System.out.print("Do you want to search another student details? (y/n)");
			           char c1=input.next().charAt(0);
             
                          if(c1=='n'){
				          menu(stId,stName, marks);
				          break;
				          }else{
							      clearConsole();
		                          System.out.println(" -----------------------------------------------------------------------");
		                          System.out.println("|                        PRINT STUDENT DETAILS                          |");
		                          System.out.println(" -----------------------------------------------------------------------\n");
					              continue L1;
					           }
		        	}
			           System.out.print("\nDo you want to search another student details? (y/n)");
			           char c1=input.next().charAt(0);
             
                          if(c1=='n'){
				          menu(stId,stName, marks);
				          break;
				          }
				 clearConsole(); 
				 System.out.println(" -----------------------------------------------------------------------");
		         System.out.println("|                        PRINT STUDENT DETAILS                          |");
		         System.out.println(" -----------------------------------------------------------------------\n");
		 } 
		
	}
		
	public static void printStudentRanks(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -----------------------------------------------------------------------");
		System.out.println("|                        PRINT STUDENT RANKS                            |");
		System.out.println(" -----------------------------------------------------------------------\n");
		
		int[] total=new int[stCount];
		int[] newTotal=new int[stCount];
		double[] avg=new double[stCount];
		
		
		for(int k=0; k<total.length; k++){
				total[k]=marks[k][0]+marks[k][1];
				}
		for(int k=0; k<total.length; k++){
				newTotal[k]=total[k];
				}		
				
		for(int k=0; k<total.length; k++){
				avg[k]=total[k]/2.0;
				Math.round((avg[k]*100.00)/100.00);
				}
		sort(newTotal);
		
		int rank[]=new int[stCount];
			for(int i=0; i<stCount; i++){
			for(int k=0; k<total.length;k++){
				if((marks[i][0]+marks[i][1])==newTotal[k]){
					rank[i]=k+1;
					break;
					}
				}
			}
	
		
		System.out.println("+-------+-------+---------------+---------------+---------------+");		
		System.out.println("|Rank\t|ID\t|Name\t\t|Total Marks\t|Avg Marks\t|");
		System.out.println("+-------+-------+---------------+---------------+---------------+");
		
		int x=0;
		for(int i=0; i<stCount; i++){
			
			for(int j=0; j<stCount; j++){
				if(rank[j]==(i+1)){
					x=j;
				if(marks[x][0]!=0 && marks[x][1]!=0){
					System.out.print("|"+(i+1)+"\t|");
					System.out.print(stId[x]);
	                System.out.print("\t|");	
			        System.out.print(stName[x]);
			        if(stName[x].length()>6){
			        System.out.print("\t|");	
		            }else{
				    System.out.print("\t\t|");
				    }	
			
			        System.out.print((marks[x][0]+marks[x][1]));
			         System.out.print("\t\t|");
			         System.out.print(avg[x]);
			         System.out.println("\t\t|");
		
		        }		
				}	
	
			}
		}
		System.out.println("+-------+-------+---------------+---------------+---------------+");
		System.out.print("\nDo you want to go back to main menu? (y/n) ");
			           char c1=input.next().charAt(0);
             
                          if(c1=='y'){
				          menu(stId,stName, marks);
				          
				          }
		}
	public static void bestInPRF(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" -------------------------------------------------------------------------------");
		System.out.println("|                        BEST IN PROGRAMMING FUNDAMENTALS                       |");
		System.out.println(" -------------------------------------------------------------------------------\n");
		
		int[] prfMarks=new int[stCount];
		
		for(int i=0;i<stCount; i++){
			prfMarks[i]=marks[i][0];
			}
		
		
		sort(prfMarks);
		
		int rank[]=new int[stCount];
			for(int i=0; i<stCount; i++){
			for(int k=0; k<prfMarks.length;k++){
				if(marks[i][0]==prfMarks[k]){
					rank[i]=k+1;
					break;
					}
				}
			}
		
		System.out.println("+-------+---------------+---------------+---------------+");		
		System.out.println("|ID\t|Name\t\t|PF Marks\t|DBMS Marks\t|");
		System.out.println("+-------+---------------+---------------+---------------+");
		int x=0;
		for(int i=0; i<stCount; i++){
			
			for(int j=0; j<stCount; j++){
				if(rank[j]==(i+1)){
					x=j;
				if(marks[x][0]!=0 && marks[x][1]!=0){
					System.out.print("|");
					System.out.print(stId[x]);
	                System.out.print("\t|");	
			        System.out.print(stName[x]);
			        if(stName[x].length()>6){
			        System.out.print("\t|");	
		            }else{
				    System.out.print("\t\t|");
				    }	
			
			        System.out.print(marks[x][0]);
			        System.out.print("\t\t|");
			        System.out.print(marks[x][1]);
			        System.out.println("\t\t|");
		
		        }		
				}	
	
			}
		}
	    System.out.println("+-------+---------------+---------------+---------------+");
		System.out.print("\nDo you want to go back to main menu? (y/n) ");
			           char c1=input.next().charAt(0);
             
                          if(c1=='y'){
				          menu(stId,stName, marks);
				          
				          }
		}
	public static void bestInDBMS(String[] stId, String[] stName,int[][] marks){
		clearConsole();
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println("|                      BEST IN DATABASE MANAGEMENT SYSTEMS                     |");
		System.out.println(" ------------------------------------------------------------------------------\n");
		
		int[] dbmsMarks=new int[stCount];
		
		for(int i=0;i<stCount; i++){
			dbmsMarks[i]=marks[i][1];
			}
		
		
		sort(dbmsMarks);
		
		int rank[]=new int[stCount];
			for(int i=0; i<stCount; i++){
			for(int k=0; k<dbmsMarks.length;k++){
				if(marks[i][1]==dbmsMarks[k]){
					rank[i]=k+1;
					break;
					}
				}
			}
				
		
		System.out.println("+-------+---------------+---------------+---------------+");		
		System.out.println("|ID\t|Name\t\t|DBMS Marks\t|PF Marks\t|");
		System.out.println("+-------+---------------+---------------+---------------+");
		int x=0;
		for(int i=0; i<stCount; i++){
			
			for(int j=0; j<stCount; j++){
				if(rank[j]==(i+1)){
					x=j;
				if(marks[x][0]!=0 && marks[x][1]!=0){
					System.out.print("|");
					System.out.print(stId[x]);
	                System.out.print("\t|");	
			        System.out.print(stName[x]);
			        if(stName[x].length()>6){
			        System.out.print("\t|");	
		            }else{
				    System.out.print("\t\t|");
				    }	
			
			        System.out.print(marks[x][1]);
			        System.out.print("\t\t|");
			        System.out.print(marks[x][0]);
			        System.out.println("\t\t|");
		
		        }		
				}	
	
			}
		}
		 System.out.println("+-------+---------------+---------------+---------------+");
		System.out.print("\nDo you want to go back to main menu? (y/n) ");
			           char c1=input.next().charAt(0);
             
                          if(c1=='y'){
				          menu(stId,stName, marks);
				          
				          }
		}		
	public final static void clearConsole() {
           try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
			  new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
			}
     } catch (final Exception e) {
       e.printStackTrace();
       // Handle any exceptions.
     }
   }
   public static boolean isInteger(String str) {
	   
	    String sub = str.substring(0, 1);
	    if(sub.equals("0")){
			return false;
		}else{
				
		  try {
          Integer.parseInt(str);
          return true;
          }
            catch (NumberFormatException nfe) {
            return false;
            }	
		}
}
      public static void sort(int[] a){
		for(int i=a.length-1;i>0; i--){
			for(int j=0; j<i; j++){
				if(a[j]<a[j+1]){
					int t=a[j+1];
					a[j+1]=a[j];
					a[j]=t;
				}
			}
		}
	}
		
	public static void main(String args[]){
		
		String[] stId = new String[1];
		String[] stName = new String[1];
		int[][] marks=new int[1][2];
		
		menu(stId,stName,marks);
	}
	
}
