# HTMLFILE
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spotify</title>
    <link href="style.css" rel="stylesheet"/>
</head>
<body>
    <nav>
        <ul>
        <li id="1" class="brand"><img src="logo.png" alt="Spotify"/>Spotify</li>
            <li>Home</li>
            <li>about</li>
        </ul>
    </nav>
    <div class="container">
        
        <div class="songlist">
            <h1>Best of Travis Scott</h1>
            <div class="songItemcontainer">
                <div class="songItem">
                    <img src="yoyoimages.jpg" alt="1"/>
                    <span class="songName">Goosebumps</span>
                    <span class="songlist"><span class="timestamp">3:20<i id="0" class="far songItemPlay fa-play-circle"></i></span>  
                </div>
                <div class="songItem">
                    <img src="yoyoimages.jpg" alt="1"/>
                    <span class="songName">Butterfly Effect</span>
                    <span class="songlist"><span class="timestamp">3:40<i id="1" class="far songItemPlay fa-play-circle"></i></span>  
                </div>
                <div class="songItem">
                    <img src="yoyoimages.jpg" alt="1"/>
                    <span class="songName">Stargazing</span>
                    <span class="songlist"><span class="timestamp">3:55<i id="2" class="far songItemPlay fa-play-circle"></i></span>  
                </div>
                <div class="songItem">
                    <img src="yoyoimages.jpg" alt="1"/>
                    <span class="songName">Mafia</span>
                    <span class="songlist"><span class="timestamp">4:20<i id="3" class="far songItemPlay fa-play-circle"></i></span>  
                </div>
                <div class="songItem">
                    <img src="yoyoimages.jpg" alt="1"/>
                    <span class="songName">Anidote</span>
                    <span class="songlist"><span class="timestamp">2:59<i id="4" class="far songItemPlay fa-play-circle"></i></span>  
                </div>
            </div>
        </div>
        <div class="songbanner"></div>
    </div>
    <div class="bottom">
        <input type="range" name="range" id="myProgressBar" value="0" min="0" max="100"/>
        <div class="icons">
            
            <i class="fas fa-2x fa-step-backward" id="previous"></i>
            <i class="fas fa-2x fa-play-circle" id="masterPlay"></i>
            <i class="fas fa-2x fa-step-forward" id="next"></i>
        </div>
        <div class="songinfo">
            <img src="playing.gif"  width="42px" alt="" id="gif"> <span id="masterSongName">Goosebumps</span>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/2ea7a9e791.js" crossorigin="anonymous"></script>
    <script src="script.js"></script>
</body>
</html>

## CSSFILE

*{
    margin: 0;
    padding: 0;
}

body{
    background-color: lightsalmon;
}
nav{
    font-family:'Times New Roman', Times, serif;
    display: flex;
}
nav ul{
    display: flex;
    align-items: center;
    list-style-type: none ;
    height: 55px;
    width: 100%;
    background-color: black;
    color: #fff;
    
    
}
nav ul li{
    padding: 0px 12px;
    
}
.brand img{
     width: 50px;
    padding: 0px 9px;
}
.brand{
    display: flex;
    align-items: center;
    font-weight: bolder;
    font-size: 1.3rem;
}
.container{
    min-height: 70vh;
    background-color: black;
    font-family: Georgia, 'Times New Roman', Times, serif;
    color: #fff;
    display: flex;
    margin: 23px auto;
    width: 70%;
    border-radius: 12px;
    padding: 34px;
    background-image: url(travisscott.jpg);
}
.bottom
{
    background-color: black;
    color: #fff;
    position: sticky;
    height: 100px;
    bottom: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    
}
.icons{
    margin-top: 14px;
}
.icons i{
    cursor: pointer;
}
#myProgressBar
{
    width:80vw;
    cursor: pointer;
}
.songItem{
    height: 56px;
    display: flex;
    background-color: white;
    
    color: black;
    margin:12px 0px;
    
    justify-content: space-between;
    align-items: center;
    border-radius: 30px;

}
.songItem img{
    width: 80px;
    margin: 0 23px;
    border-radius: 30px;
}
.timestamp{
    
    margin:0 23px;
}
.timestamp i{
    cursor: pointer;

}
.songItemcontainer{
    margin-top: 50px;
}
.songinfo
{
position: absolute;
left:9vw;
font-family:Verdana, Geneva, Tahoma, sans-serif;
}
.songinfo img{
    opacity:0;
    transition: opacity 0.4s ease-in;
} 

### JS FILE
console.log("Welcome to Spotify");
let songIndex=0;
let audioElement=new Audio('songs/goosebumps.mp3');
let masterPlay=document.getElementById('masterPlay');
let myProgressBar=document.getElementById('myProgressBar');
let gif =document.getElementById('gif');
let songItems=Array.from(document.getElementsByClassName('songItem')); 

let songs=[
    {songName: "Goosebumps",filepath:"songs/goosebumps.mp3", coverpath:"covers/yoyoimages.jpg"},
    {songName: "Butterflyeffect",filepath:"songs/butterflyeffect.mp3", coverpath:"covers/yoyoimages.jpg"},
    {songName: "Stargazing",filepath:"songs/stargazing.mp3", coverpath:"covers/yoyoimages.jpg"},
    {songName: "Mafia",filepath:"songs/mafia.mp3", coverpath:"covers/yoyoimages.jpg"},
    {songName: "Antidote",filepath:"songs/antidote.mp3", coverpath:"covers/yoyoimages.jpg"},
]

songItems.forEach((element,i)=>{
    element.getElementsByTagName("img")[0].src= songs[i].coverpath;
    element.getElementsByClassName("songName")[0].innerText= songs[i].songName;
})

//audioElement.play();
//handle pause/play click button
masterPlay.addEventListener('click',()=>{
    if(audioElement.paused || audioElement.currentTime<=0){
        audioElement.play();
        masterPlay.classList.remove('fa-play-circle');
        masterPlay.classList.add('fa-pause-circle');
        gif.style.opacity=1;
    }
    else
    {
        audioElement.pause() ;
        masterPlay.classList.remove('fa-pause-circle');
        masterPlay.classList.add('fa-play-circle');
        gif.style.opacity=0;
    }
})
//listen to events
audioElement.addEventListener('timeupdate',()=>
{
    //update seekbar
    progress=parseInt((audioElement.currentTime/audioElement.duration)*100);
    myProgressBar.value=progress;
})

myProgressBar.addEventListener('change',()=>
{
   
    audioElement.currentTime= (myProgressBar.value)*(audioElement.duration)/100;
})
const makeAllPlays = ()=>(
    Array.from(document.getElementsByClassName('songItemPlay')).forEach((element)=>
    {
        element.classList.remove('fa-pause-circle');
        element.classList.add('fa-play-circle');
    })
)
Array.from(document.getElementsByClassName('songItemPlay')).forEach((element)=>{
    element.addEventListener('click',(e)=>{
        makeAllPlays();
        songIndex =parseInt(e.target.id);
        e.target.classList.remove('fa-play-circle');
        e.target.classList.add('fa-pause-circle');
        audioElement.src ='songs/${songIndex+1}.mp3';
        masterSongName.innerText = songs[songIndex].songName;
        audioElement.currentTime=0;
        audioElement.play();
        gif.style.opacity = 1;
        masterPlay.classList.remove('fa-play-circle');
        masterPlay.classList.add('fa-pause-circle');
        

    })
})
//copied
document.getElementById('next').addEventListener('click', ()=>{
    if(songIndex>=4){
        songIndex = 0
    }
    else{
        songIndex += 1;
    }
    audioElement.src = 'songs/${songIndex+1}.mp3';
    masterSongName.innerText = songs[songIndex].songName;
    audioElement.currentTime = 0;
    audioElement.play();
    masterPlay.classList.remove('fa-play-circle');
    masterPlay.classList.add('fa-pause-circle');

})

document.getElementById('previous').addEventListener('click', ()=>{
    if(songIndex<=0){
        songIndex = 0
    }
    else{
        songIndex -= 1;
    }
    audioElement.src = 'songs/${songIndex+1}.mp3';
    masterSongName.innerText = songs[songIndex].songName;
    audioElement.currentTime = 0;
    audioElement.play();
    masterPlay.classList.remove('fa-play-circle');
    masterPlay.classList.add('fa-pause-circle');
})
                     
                     
  #### README
                     ![image](https://user-images.githubusercontent.com/86347034/197942398-ad865f19-3034-4e35-adce-b103bb3985ef.png)
![image](https://user-images.githubusercontent.com/86347034/197942425-d3ebdd1f-22e9-471a-9745-a097db24ba33.png)

