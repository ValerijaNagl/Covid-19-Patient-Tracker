# Covid-19-Patient-Tracker
-This is a school project/android application whose main task is to ilustrate work with basic Android concepts as RecyclerView, ViewModel etc. 
-It containts 3 activities - one of them is splash activity that checks if user (medical worker) is logged, if he will get list of patients (3 fragments show with view pager) who are waiting to get
checked, who are hospitalized or who are released. You can add new patient to waiting room, put patient in hospital, change hospitalized patient's info and release patient.
You can also change user's credentials.
Tehnologies used in project: on presentation layer I used ViewModel and LiveData. User's info are stored in SharedPreferances. RecyclerView is used for patients data. Data used in
RecyclerView are dummy data (they do not survive if app closes).
