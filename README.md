# SchoolJournal

Here you can see a little program for School Journal

Program can read information from file "subjects.xml"
Please, put this File into "C:/Projects/" 

Also, porgram read info from file and put it into the specific structure called InstanceImpl
you can take or add all info from/to this structure using methods/

InstanceImpl - Singleton, so you can get it by using getInstance() method

From here you can add or take info by
- addSubject(String name)
- getSubjectByName(String name)

Work with subject is simple and allows you to use such methods as:
- createJournal(int classNumber, String classLiter)
- getJournalByClass(int classNumber, String classLiter)
- deleteInlying(int classNumber, String classLiter) - deletes all info into this subject

And etc.
