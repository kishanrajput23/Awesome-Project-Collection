export default function Timer(props) {
    let timerText = '';

    if (props.minutes < 1) {
        timerText = `${props.seconds} seconds`;
    }
    else if (props.minutes < 10) {
        timerText = `${props.minutes}:${props.seconds < 10 ? '0' : ''}${props.seconds}`;
    } 
    else {
        timerText = '∞';
    }
    return (
        <p className="timer">
            {`Time Elapsed : ${timerText}`}
        </p>
    );
};