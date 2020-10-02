from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
from textblob import TextBlob
import tweepy
import json
import twitter_credentials
import time
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import re
import os
os.remove("tweets.json")
'''

# # # # SEARCH WALA PART # # # #

auth = OAuthHandler(twitter_credentials.CONSUMER_KEY, twitter_credentials.CONSUMER_SECRET)
auth.set_access_token(twitter_credentials.ACCESS_TOKEN, twitter_credentials.ACCESS_TOKEN_SECRET)
data = api.search(q='dceu', count = 100,result_type='popular')
tweets=[]

for i in range(len(data)):
    tweets.append(data[i]._json)

fp = open("try.json","a")

for tweet in tweets:
    print(json.dumps(tweet), file=fp)


# # # # # # # # # # # # # # # #
'''

# # # # TWITTER STREAMER # # # #
class TwitterStreamer():
    """
    Class for streaming and processing live tweets.
    """
    def __init__(self):
        pass

    def stream_tweets(self, fetched_tweets_filename, hash_tag_list):
        # This handles Twitter authetification and the connection to Twitter Streaming API
        listener = StdOutListener(fetched_tweets_filename,time_limit=60)
        auth = OAuthHandler(twitter_credentials.CONSUMER_KEY, twitter_credentials.CONSUMER_SECRET)
        auth.set_access_token(twitter_credentials.ACCESS_TOKEN, twitter_credentials.ACCESS_TOKEN_SECRET)
        stream = Stream(auth, listener)

        # This line filter Twitter Streams to capture data by the keywords:
        stream.filter(track=hash_tag_list)

# # # # TWITTER STREAM LISTENER # # # #
class StdOutListener(StreamListener):
    """
    This is a basic listener that just prints received tweets to stdout.
    """
    def __init__(self, fetched_tweets_filename,time_limit=60):
        self.fetched_tweets_filename = fetched_tweets_filename
        self.start_time = time.time()
        self.limit = time_limit
        self.tf = open(fetched_tweets_filename,'a')
        super(StdOutListener, self).__init__()

    def on_data(self, data):
        try:
            #print(data)
            #with open(self.fetched_tweets_filename, 'a') as tf:
            if (time.time() - self.start_time) < self.limit:
                self.tf.write(data)
                return True
            else:
                self.tf.close()
                return False
        except BaseException as e:
            print("Error on_data %s" % str(e))
        return True


    def on_error(self, status):
        print(status)

        ''' Pandas wala part  '''
class TweetAnalyzer():
    """
    Functionality for analyzing and categorizing content from tweets.
    """

    def clean_tweet(self, tweet):
        return ' '.join(re.sub("(@[A-Za-z0-9]+)|([^0-9A-Za-z \t])|(\w+:\/\/\S+)", " ", tweet).split())

    def analyze_sentiment(self, tweet):
        analysis = TextBlob(self.clean_tweet(tweet))

        if analysis.sentiment.polarity > 0:
            return "Positive"
        elif analysis.sentiment.polarity == 0:
            return "Neutral"
        else:
            return "Negative"

    def tweets_to_data_frame(self, tweets):
        df = pd.DataFrame(data=[tweet['text'] for tweet in tweets], columns=['tweets'])

        df['user_name'] = np.array([tweet['user']['screen_name'] for tweet in tweets])
        df['followers'] = np.array([tweet['user']['followers_count'] for tweet in tweets])
        #df['tweet'] = np.array([tweet['text'] for tweet in tweets])
        #df['date'] = np.array([tweet['created_at'] for tweet in tweets])
       # df['source'] = np.array([tweet['source'] for tweet in tweets])
       # df['likes'] = np.array([tweet['favorite_count'] for tweet in tweets])
       # df['retweets'] = np.array([tweet['retweet_count'] for tweet in tweets])

        return df


if __name__ == '__main__':

    path = input("Search for recent or popular tweets? ")

    if(path == 'recent'):

        # Authenticate using config.py and connect to Twitter Streaming API.
        tweet_analyzer = TweetAnalyzer()
        hash_tag_list = input("Enter hashtag(s) to search: ").split() # ['#dceu','dceu']
        print("Please wait while we fetch your request...\n")
        fetched_tweets_filename = "tweets.json"
        twitter_streamer = TwitterStreamer()
        twitter_streamer.stream_tweets(fetched_tweets_filename, hash_tag_list)
        #tf = open('tweets.txt','r')
        with open('tweets.json','r') as fy:
            data = [json.loads(line) for line in fy]
        tweets = data
        df = tweet_analyzer.tweets_to_data_frame(tweets)
        df['Sentiment of the tweet'] = np.array([tweet_analyzer.analyze_sentiment(tweet) for tweet in df['tweets']])

        if not df.empty:
            subchoice=''
            stmt=''
            follow=0
            choice=input("Select option:(print_all/use_condition)")
            if(choice=='print_all'):
                print(df)
            elif(choice=='use_condition'):
                 subchoice=input('\nCondition on:(sentiment/followers)')
                 if(subchoice=='sentiment'):
                     stmt = input('Positive/Negative/Neutral ')
                     print(df[df['Sentiment of the tweet'] == stmt])
                 elif(subchoice=='followers'):
                      follow = int(input("Enter minimum follower count: "))
                      print(df[df['followers']>follow])
            else:
                print(df)
        else:
            print("Couldn't fetch recent tweets")

    elif(path=='popular'):

        choice = input('Enter keyword to search: ')
        auth = OAuthHandler(twitter_credentials.CONSUMER_KEY, twitter_credentials.CONSUMER_SECRET)
        auth.set_access_token(twitter_credentials.ACCESS_TOKEN, twitter_credentials.ACCESS_TOKEN_SECRET)
        api = tweepy.API(auth)
        data = api.search(q=choice, count = 100,result_type='popular')
        tweets=[]

        for i in range(len(data)):
            tweets.append(data[i]._json)

        fp = open("tweets.json","a")

        for tweet in tweets:
            print(json.dumps(tweet), file=fp)

        with open('tweets.json','r') as fy:
            data = [json.loads(line) for line in fy]
        tweets = data
        tweet_analyzer = TweetAnalyzer()
        df = tweet_analyzer.tweets_to_data_frame(tweets)
        df['Sentiment of the tweet'] = np.array([tweet_analyzer.analyze_sentiment(tweet) for tweet in df['tweets']])
        print(df)
