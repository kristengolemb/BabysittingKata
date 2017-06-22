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
Attempting to use StartTime and EndTime classes started to get really complicated, so the project has been streamlined into one class that sets the start, bed, and end times and calculates the hours worked and amount owed to the babysitter. CHRONOUNIT.Hours ensures that the babysitter is only paid for full hours, though it is a little unfair (for example, if the babysitter worked until 9:45, they would only be paid up until 9 as CHRONOUNIT rounds down).
