<h1 align="center"><strong>CSIS 3275-070 Software Engineering</strong></h1>
<h5 align="center"><strong>Beware, this is a living document and it will be continuously updated!!! 🚀</strong></h5>
<br/>

<blockquote>
  <br/>
  <h2><strong>"Documentation is a love letter that you write to your future self." - Damian Conway</strong></h2>
  <br/>
</blockquote>
<br/>

<h2>🎯 <strong>Objectives</strong></h2>
<p>
  This repository comprises a <strong>RESTful Web service</strong> implemented in Java using the Spring Boot framework and exploit several concepts learned in class. The proposed project is a <strong>E-Commerce</strong> system that provide features such as:
</p>
<br/>

<h2>🏗 <strong>Features List & Description</strong></h2>
<ul>
    <li>Host and consume images from AWS S3</li>
    <li>Gmail SMTP service</li>
    <li>Caching data in the browser with Redis</li>
    <li>Product recomendation</li>
    <li>Authentication and Authorization with JWT</li>
    <li>Track cart</li>
    <li>Payment</li>
</ul>
<br/>

<h2>👥 <strong>Contributors</strong></h2>
<br/>
<a style="padding-left: 20px" href="https://github.com/leandrofahur">Leandro Machado - 300326045</a>
<a style="padding-left: 20px" href="https://github.com/marimagalhaesl">Mariana Magalhães - 300330330</a>
<a style="padding-left: 20px" href="https://github.com/sebastian-gm">Sebastian Gonzalez - 300326988</a>
<a style="padding-left: 20px" href="https://github.com/FourSeasonK">Sung Ah Kim - 300341721</a>
<br/>

<h2>🥷 <strong>Github Best Practices</strong></h2>

<strong>Clone the repository:</strong>

```javascript
$ git clone https://github.com/leandrofahur/se_project_backend.git
```

<strong>Create your own branch:</strong>

```javascript
$ git checkout -b  <branch_name>
```

If you are in the main branch, this command will copy the main one and create a new branch named <branch_name>.

<strong>Staging, commiting and pushing:</strong>

```javascript
$ git add .
```

```javascript
$ git commit -m "a comment describing what this commit is about"
```

```javascript
$ git push
```

If you are pushing for the first time, git will ask you to execute the command

```javascript
$ git push --set-upstream origin <branch_name>
```

Where the <branch_name> tag is the name of your local branch that is going to be created on the remote repository.

<strong>Always keep things up to date:</strong>

```javascript
$ git pull
```

If you are pulling for the first time, git will ask you to execute a command similar to the one listed for push.

<strong>Wrapping up:</strong>

After finishing your work, and the branch is ready to merge with master, execute the following:

```javascript
$ git checkout master
```

and then

```javascript
$ git merge <branch_name>
```

<strong>Delete branch locally</strong>

```javascript
$ git branch -d localBranchName
```

<strong>Delete branch remotely</strong>

```javascript
$ git push origin --delete remoteBranchName
```

More about can be found in the link on the references section.

<br/>

<h2>📝 <strong>References</strong></h2>
<ol>    
  <li>
    <a href="https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository">
        Github - Configuring branches and merges in your repository
    </a>
  </li>
</ol>
<br/>

<h2>🔐 <strong>License</strong></h2>
<p>Copyright © 2021 - This project is <a href="./LICENSE">MIT</a> licensed.</p>
