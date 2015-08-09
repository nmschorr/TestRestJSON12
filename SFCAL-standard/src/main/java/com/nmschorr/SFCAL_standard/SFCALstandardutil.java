package com.nmschorr.SFCAL_standard;


import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import static java.lang.System.out;
//import static com.nmschorr.SFCAL_editor.SFCALeditor.verboseOut;
import static com.nmschorr.SFCAL_standard.SFCALstandard.*;

	
public class SFCALstandardutil {
	final static String LINE_FEED  =  System.getProperty("line.separator");
	static final String newfront  =  "DTEND:";
	static String NEWREPLACEDstring;
	static String perfectString;
	static int keepcount = 1;
	static String replacedSignString;
	static String voidFixedString;
	String newSTR2="yes";	
	//static boolean useSUMMARYstr = false;
	String[] plansArry = {"Sun", "Mon","Mer", "Ven", "Mar", "Jup", "Sat","Nep", "Ura", "Plu"};		
	
	
	
	static void generalStringFixing(String SFCALtempOneFilename, String sfcalFilename) {   
		String genMainCharString = "";
		boolean keepGoing = true;
		File sfcalFile = new File(sfcalFilename);
		String newSTR = "";
		String newLocLINE="";
		String newLocLINE2="";
		
		File SFCALtempONE  =  new File(SFCALtempOneFilename);
		CharSequence SUMstr = "SUMMARY:Tr-Tr";
		String DEStr = "DESCRIPTION";

		try {
			List<String> genFileARRAY  =   FileUtils.readLines(sfcalFile);
			int realCOUNT  =  genFileARRAY.size();
			int safeCount = realCOUNT-5;
			System.out.println("realCOUNT:  " +  realCOUNT + "   safecount:  " +  safeCount);			
			System.out.println("----------------------------------%%%%%%%##### total lines: " +  genFileARRAY.size());
			// get ics header lines in 1st-first four header lines of ics inFileName

			// for each line in file:
			for (String cLINE : genFileARRAY)  {
				keepGoing = checkLINEfunction(cLINE, safeCount) ;		
				G_VERBOSE = 1;

				if (keepGoing == true ) { 
					StringUtils.chomp(cLINE);
					System.out.println("realcount:  " + realCOUNT);
					verboseOut(        "current line:               " + cLINE);

					genMainCharString  =   checkForChar(cLINE);
					System.out.println("    char string is:         " + genMainCharString);

					if ( cLINE.contains(SUMstr)) {  /// if TR-TR only lines
						newSTR = gofixhash(genMainCharString) ;
						FileUtils.writeStringToFile(SFCALtempONE, newSTR +"\n", true);	
					}										
					else if ( cLINE.contains(DEStr) || cLINE.startsWith(" "))   {  /// if TR-TR only lines
						newSTR = gofixDES(genMainCharString) ;
						FileUtils.writeStringToFile(SFCALtempONE, newSTR +"\n", true);	
					}										
					else if (cLINE.startsWith("SUMMARY:Tr "))   { 
						newLocLINE = cLINE.replace("Tr ", "");
						
						String oldPlanet = "";
						String newPlanet = "";
						String dchar = " D";  
						String rchar = " R";  // MUST have a space first

						Map<String, String> newhash  =  makeNewhash();
						
						int cStart = newLocLINE.length()-3;  // a space & there's a line ending too
						int cEnd = newLocLINE.length()-1;
						String newSub = newLocLINE.substring(cStart,cEnd);  // get the last char
						
						if (newSub.equals(rchar))  {  
							newLocLINE2  = newLocLINE.replace(rchar, " goes Retrograde");
						}
						else if (newSub.equals(dchar))  { /// if TR-TR only lines
							newLocLINE2  = newLocLINE.replace(dchar, " goes Direct");
						}
						newSTR=newLocLINE2;
						
						oldPlanet = newSTR.substring(8,11);
						if ( newhash.containsKey(oldPlanet)) {
							newPlanet = (newhash.get(oldPlanet));
						}
						newLocLINE= newSTR.replace(oldPlanet, newPlanet);
						FileUtils.writeStringToFile(SFCALtempONE, newLocLINE +"\n", true);	
					}  // SUMMARY:TR 	
					else if ( cLINE.contains("DTSTAR") ) {
						String theDTSTline = chkAddDTEND(cLINE);
						FileUtils.writeStringToFile(SFCALtempONE, cLINE, true);  // start line
						FileUtils.writeStringToFile(SFCALtempONE, theDTSTline, true);
				}
					else {
						System.out.println("   writing ALT string to file         " + genMainCharString);
						FileUtils.writeStringToFile(SFCALtempONE, genMainCharString +"\n", true);	
					}
					keepcount++;
				}	// if

			}  //for string in array
		}  // try
		catch (IOException e)  { 
			e.printStackTrace();	 
		}  // catch
	}	// end of method
	
	static String chkAddDTEND (String theLine) {
		if ( theLine.contains("DTSTAR") )   {  		// double check			
			String newback = theLine.substring(8,23) + "Z";
			out.println("!!@@@@@  the line is  " + theLine);
			String newDTEND = newfront + newback +"\n";  					
			out.println("DTEND: new line is " + newDTEND);
			return newDTEND;
		}
		else return theLine;
	}
	
	static HashMap<String, String>  makeNewhash() {
		HashMap <String, String> localHash  =  new HashMap<String, String>();
		localHash.put("Mon", "Moon");
		
		localHash.put("Ari", "Aries");
		localHash.put("Tau", "Taurus");
		localHash.put("Gem", "Gemini");
		localHash.put("Can", "Cancer");
		localHash.put("Leo", "Leo");
		localHash.put("Vir", "Virgo");
		localHash.put("Lib", "Libra");
		localHash.put("Sco", "Scorpio");
		localHash.put("Sag", "Sagittarius");
		localHash.put("Cap", "Capricorn");
		localHash.put("Aqu", "Aquarius");
		localHash.put("Pis", "Pisces");

		localHash.put("Cnj", "Conjunct");
		localHash.put("Tri", "Trine");
		localHash.put("Opp", "Opposite");
		localHash.put("Sqr", "Square");
		localHash.put("Sxt", "Sextile");
		localHash.put("Qnx", "Quincunx");
		
		localHash.put("Sun", "Sun");
		localHash.put("Mer", "Mercury");
		localHash.put("Ven", "Venus");
		localHash.put("Mar", "Mars");
		localHash.put("Jup", "Jupiter");
		localHash.put("Sat", "Saturn");
		localHash.put("Nep", "Neptune");
		localHash.put("Ura", "Uranus");
		localHash.put("Plu", "Pluto");		
	return localHash;
	}

	
	
	
	static String myREPLACE(String bigstr, String oldStr, String newStr) {
		if ( bigstr.contains(oldStr) ) {
			bigstr.replace(oldStr, newStr);
		}		
		return bigstr;
	}
	
	public static void delFiles(File f1) {
		if ( f1.exists() ) {
			f1.delete();  // delete the inFileName we made last time
		}
	}

	protected static void mySleep(int timewait) {
		try {
			Thread.sleep(timewait * 1000);	//sleep is in milliseconds
		} catch (Exception e) {
			System.out.println(e);
		} 
	  } // mySleep
	
	static String checkForChar(String checkLine) {
		 
		if (checkLine.contains( "\uFFFD"))  {
			System.out.println("!!!---            ---FOUND WEIRD CHAR -----!!!!  !!!  ");
			System.out.println(checkLine);	
			String newStringy  =  checkLine.replace( "\uFFFD", " ");  
			//String newStringy2  =  newStringy.replace( "'", " ");  
			System.out.println("The fixed line: " + newStringy);
			return newStringy;
		}
		else { return checkLine;
			}
		}
		static boolean checkLINEfunction(String theLocLine, int safecount) {
			boolean KG = true;
			if   ((theLocLine.length() > 0 ) && (theLocLine.length() < safecount) )   {

				if   ((theLocLine.length() > 0 )  
						&& (keepcount < 400) )   { KG  =  true; } 
				else { KG = false; }

				if ( ( theLocLine.contains("THISISATESTONLY")) 
					//	( theLocLine.contains("TRANSPARENT")) 
						///     ||
					//	( theLocLine.contains("DTEND")) || 
					//	( theLocLine.contains("VCALENDAR")) || 
					//	( theLocLine.contains("VEVENT")) || 
					//	( theLocLine.contains("DTSTART")) || 
					//	( theLocLine.contains("PRODID:")) || 
					//	( theLocLine.contains("VERSION:")) || 
					//	( theLocLine.contains("METHOD:")) || ( theLocLine.contains("UID")) 
					//	|| ( theLocLine.contains("CATEGORIES")) || ( theLocLine.contains("DTSTAMP")) 
						)

				{ 
				 KG =false; 
				}
			}
			//System.out.println ("val of KG is :" + KG);
			return KG;
		}
		
		
		static HashMap<String, String>  makemyhash() {
			HashMap <String, String> myHashmap  =  new HashMap<String, String>();
			myHashmap.put("Cn", "Cancer ");
			myHashmap.put("Ar", "Aries ");
			myHashmap.put("Ta", "Taurus ");
			myHashmap.put("Sg", "Sagittarius ");
			myHashmap.put("Ge", "Gemini ");
			myHashmap.put("Le", "Leo ");
			myHashmap.put("Vi", "Virgo ");
			myHashmap.put("Li", "Libra ");
			myHashmap.put("Sc", "Scorpio ");
			myHashmap.put("Cp", "Capricorn ");
			myHashmap.put("Aq", "Aquarius ");
			myHashmap.put("Pi", "Pisces ");
			return myHashmap;
		}

//		static void dtstar() {
//		String firstfront;
//		String newback;
//		String newComboStr;  
//		firstfront  =  checkCharString.substring(0,6);
//		if ( firstfront.equals("DTSTAR") )   {  					
//			String newback  =  checkCharString.substring(8,23) + "Z";
//			verboseOut("!!@@@@@  the line is  " + checkCharString);
//			newComboStr  =  newfront + newback +"\n";  					
//			verboseOut("DTEND: new line is " + newComboStr);
//			FileUtils.writeStringToFile(SFCALtempONE, newComboStr, true);	
//			}
//		}
	
}



 	