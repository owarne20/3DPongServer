module a3DPong
{


    interface Server
    {
        void sendBallPositionAndVector(float x, float y, float vX, float vY);
        void startGame(float vX, float vY);
        void startDirectionHint(float vX, float vY, int seconds, int padding);
        void disconnect(string reason);
        void sendPaddlePositionX(float x);
        void sendTime(float timeInSeconds);
        void ready(byte b);
        void timeModifier(float t);
        void sendScore(int score, byte side);
    }
    interface Client
    {
        void sendServerCallback(Server* server);
        void sendPaddlePositionX(float x);
        void disconnect(string reason);
    }
}