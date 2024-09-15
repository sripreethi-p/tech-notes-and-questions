# HR Interview Questions

### 1. Tell me about yourself.
**Purpose:** HR wants to gauge your communication skills, confidence, and get a quick overview of your background.

**Tips to answer:**
- Background (java-backend)
- Technologies, languages, frameworks worked on
- Impact of a major project you've led
- Skills & interests   

**Example:** 
- I have been working as a Java Backend Developer _[background]_ in Target _[current company]_ for 3 years now _[experience]_. 
- I joined the company as a fresher in 2021. 
- I've graduated from NIT Karnataka, Surathkal. 
- In my current team, I've majorly worked on Java, Springboot, SQL & NoSql databases, etc. _[technologies worked on]_.
- I usually enjoy work that involves problem-solving. If it demands for new skills, I like to take those opportunities to learn new things & execute them._[skills]_

<br></br>


### 2. Why do you want to work here?
**Purpose:** To assess your motivation and how much you know about the company.  

**Tips to answer:**
- Your interest in the domain
- Company's standard in the domain
- Your introduction to the company
- Research about its core values
- Mention a recent advancement in the company

**Example:** 
- From my time in Target, I've really come to like the Retail Space _[domain]_
- As one of the leading retailers, Walmart is a company I truly aspire to work for _[company standard]_
- At Target, the team I worked with focused on competitor pricing, particularly Walmart's. I've been impressed by Walmart's ability to block bot crawlers effectively and implement rapid price adjustments both in-store and online, and faster deliveries which highlights the strength of their tech teams. I am eager to work alongside such innovative teams. _[introduction to the company]_
- The core values of Walmart: Respect, Service, Excellence & Integrity are part of my work ethic as well. _[core values]_


<br></br>


### 3. Why do you want to leave your current company?

**Example:**
- Both my individual growth and the team's growth slowed down drastically.
- The work was pretty much saturated, I was not getting any work that would improve any of my skills.
- Tried moving to other teams, but couldn't due to business requirements
- I also wanted more exposure to how other organizations work as well


### 4. What are your strengths and weaknesses?
**Purpose:** To understand your self-awareness and areas for improvement

**Tips to answer:**
- Highlight strengths that are relevant to the role (e.g., technical skills, teamwork, problem-solving)
- When discussing weaknesses, focus on areas you are actively working to improve.

**Example:**
- **(+)** I'm a curious person. I like to learn new things and apply them when required.
- **(+)** Work that involves problem-solving really excites me
- **(+)** I've been a good team player and mentor to junior developers. When I'm expected to guide them, I don't directly hand over the solutions to them, instead I try to come up with hints and questions that help them reach the solutions and evaluate those by themselves.


- **(-)** I tend to over-prioritize perfection over meeting the immediate requirements which slows down my work sometimes. But I'm actively working on it by setting clear priorities and focusing on them first.


<br></br>


### 5. Tell me about a challenge you faced in a project and how you handled it.
**Purpose:** HR is evaluating your problem-solving abilities and how you handle pressure

**Tips to answer:**
- Pick a problem which involves technical, assessment, planning and analysis skills
- Explain the problem with constraints and requirements
- Explain how you've arrived at the approach
- Explain your thought processes, efforts (what you had to do)
- Explain the results & the impact

**Example:**
- We had a use case of evaluating if a price signal received is actually what is present on the website or not. _[explain problem]_
- We had to come up with a strategy to compute a score of confidence for a price signal.
- The major problems I've seen while solving this: _[list out constraints & requirements]_
  - Since this is a very new initiative, it was a clean slate where we had no idea about the patterns/computing logics/possible outcomes.
  - This could get data intensive, since we had to deal with historical data.
  - At the same time, we had to maintain low latencies so it won't slow down our everyday process to sending data downstream.
  - Impact expectancy was very vague, no idea on what items/weeks to focus on.
  - Further developments were very result-oriented, hence a very well-structured plan was necessary.
- To address these issues: _[thought processes & efforts]_
  - I've come up with multiple strategies on designing the computation logic & had many discussions with the leadership to take their opinions.
  - Once we've finalized the logics, I had to decide the tools for handling different kinds of data. So I had to research multiple options to understand which would suit which use case better.
  - Once the tools were decided, I looked into ways of optimizing the response times. I've used multi-threading and parallel streams to process IO calls for multiple requests. And I've also used caching for cases of repetitive but possibly same response cases.
  - Once we had the application working, I've run multiple layers of analyses to understand the impact.
  - I had to carefully structure the plan by listing down all the possible outcomes & bottlenecks and what to do when they do occur.
  - And I also have come up with a reposting system for the cases of anomalies i.e., incorrect price points to vendors which also saved a lot of money.
- Impact: _[impact]_
  - We were able to report 3 million signals for about 30–40k items which were incorrect, but were being sent to downstream systems earlier.
  - This also helped us see and read into different patterns in the pricing strategies of multiple competitor retailers.



<br></br>



### 6. Where do you see yourself in 5 years?
**Purpose:** To understand your career aspirations and whether they align with the company.

**Tips to answer:**
- The position you want to be in
- Plans for individual career growth
- Plans for team's growth

**Example:**
- In 5 years, I see myself as a lead software developer efficiently leading a team where can I will be contributing to architectural designs to complex problems, mentoring the developers in the team, introducing new technologies into the team. _[position]_
- I plan to work more on my technical skills in secure & efficient coding practices, integrating new tools & designing solutions, etc. _[individual growth]_
- For the team I will be part of - I want to make sure of good coding practices in use, and learning opportunities for the team. And also not just delivering the set goals in time, but also achieving more than that. _[team growth]_

<br></br>


### 7. Why should we hire you?
**Purpose:** To see if you can confidently pitch your unique value proposition.

**Tips to answer:**
- Come up with a USP 
- And other smaller qualities as well
- Give examples to support your statements

**Example:**
- I cannot say I have something unique that nobody has. But I bring multiple skills to the table that are beneficial to the organization.
- I'm good at problem-solving, my strategy is good analysis & planning. I analyze the problem, list down the options & evaluate which works better.
- I'm and have been a good team player and a mentor which will help the team prosper.
- I'm also curious when it comes to learning new things. Which not only helps with newer and efficient work but also would be a good influence on the team to keep learning.
- I try to stay cool when there is pressure, which brings in fruitful results and healthy team atmosphere.

<br></br>


### 8. Describe a situation where you had to work in a team.
**Purpose:** To assess your teamwork and communication skills.

**Tips to answer:**
- Give an example where you worked with multiple teams/members
- Your contribution
- What things you implemented for smooth execution
- Impact & Feedback of members


**Example:**
- I have recently worked on onboarding new vendors where I had to sync up with the vendor, the pricing team, and other data science teams who also consume our data
- I've come up with contracts of data for each of the teams striking balance between their requirements & our budget
- We had to call external APIs to extrapolate the final response, which caused a lot of load issues & unexpected responses.
- I had to do multiple rounds of testing to make sure of a smooth run in the production deployment.
- I actively kept all the concerned teams in the communication loop to make sure everyone is informed of any update.
- In the process, I was also guiding a junior developer on how to handle a combined project like this.
- In situations of ambiguity, like when we're not sure of who should pick up a certain problem - I've checked if we have bandwidth available before jumping into offering to work on the story.
- I made sure I was available for any questions/issues coming from downstream systems.
<br></br>



### 9. How do you stay updated with new technologies?
**Purpose:** To gauge your passion for continuous learning.

**Tips to answer:**
- How to learn in everyday work
- How to use internal resources
- How to use external resources
- Keep your mind open to go against traditional practices if required

**Example:**
- When I use certain libraries/frameworks/tools/languages daily, I make sure I'm consciously using the recent versions—understanding what changes are the newer version bringing in & the impact it would bring. _[everyday work]_
- I get involved in tech discussions happening around between principal engineers, internal tech support channels _[internal resources]_
- I try to stay updated with going through all the tech newsletters we receive.
- Apart from this, I go through blog posts & twitter posts on new tech if I come across anything interesting _[external resources]_
- For me, staying updated is not just knowing things but also executing them. We tend to fall on to the traditional practices, but I try to keep my mind open to newer technologies while also being aware of the impact it may bring. _[open mind]_
<br></br>



### 10. How do you handle deadlines and pressure?
**Purpose:** To assess your ability to manage time and stress.

**Tips to answer:**
- Stress dealing techniques
- Time management techniques

**Example:**
- I usually break down complex problems into simpler parts, so I'm not overwhelmed with the end goal.
- I try to articulate definitive goals to each of these tasks, something like completion criteria
- I put these tasks in to an order based on priority & their execution strategies.
- I realistically assign time to each of them, while also setting some buffer time aside
- I try to adjust the tasks and time assigned, based on the given deadline.
- OR try to negotiate the expected end goal or the time assigned, if the requirement seems extremely unrealistic (but this would be the last resort)
<br></br>


### 11. Do you have any questions for us?
**Purpose:** To assess your interest in the company and role.

**Tips to answer:**
- Team's work
- Learning & growth opportunities
- Working model of the team


**Example:**
- What does the team do? What technologies does it use? [team's work]
- How does the everyday work and challenges look like in the team? 
- What kind of learning resources & opportunities does the organization offer? [learning]
- What kind of personal career growth opportunities can I expect? [career growth]
- What is the current working model of the team, is it hybrid? And what about the timings?
- 