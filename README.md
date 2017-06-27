Babysitter Kata

Background
----------
This kata simulates a babysitter working and getting paid for one night.  The rules are pretty straight forward:

The babysitter 
- starts no earlier than 5:00PM
- leaves no later than 4:00AM
- gets paid $12/hour from start-time to bedtime
- gets paid $8/hour from bedtime to midnight
- gets paid $16/hour from midnight to end of job
- gets paid for full hours (no fractional hours)

Feature:
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge

Notes:
This application was built in the Eclipse IDE, with tests designed using JUnit.

Attempting to use StartTime and EndTime classes started to get really complicated, so the project has been streamlined into one class that sets the start, bed, and end times and calculates the hours worked and amount owed to the babysitter. CHRONOUNIT.Hours ensures that the babysitter is only paid for full hours.

Originally the idea was to use LocalTime, however, LocalTime considers midnight (00:00) to be the start of a new day, which meant it considered the difference between midnight and a bedtime of 8pm (20:00) to be 20 hours instead of four. Using LocalDateTime fixed this issue. LocalDateTime with CHRONOUNIT also rounds up for partial hours of 30 minutes or more, which fixes the concern I had with LocalTime wherein CHRONOUNIT always rounded down.
