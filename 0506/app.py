from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
    # todo
    return render_template('detail.html')

@app.route('/articleList', methods=['GET'])
def get_article_list():
    order = request.args.get('order')
    if order == "asc":
        order = 1
    else:
        order = -1

    article_list = list(db.articles.find({}, {'_id': 0}).sort('read_count', order))

    for article in article_list:
        article['reg_date'] = article['reg_date'].strftime('%Y.%m.%d %H:%M:%S')

    return jsonify({"article_list": article_list})

# Create
@app.route('/article', methods=['POST'])
def create_article():
    title = request.form["title"]
    content = request.form["content"]
    pw = request.form["pw"]
    print("성공")
    print(db.articles.count_documents({}))
    if db.articles.count_documents({}):
        idx = db.articles.find_one(sort=[("idx", -1)])['idx'] + 1
    else:
        idx = 1
    doc = {
        'idx': idx,
        'title': title,
        'content': content,
        'pw': pw,
        'read_count': 0,
        'reg_date': datetime.now()
    }
    db.articles.insert_one(doc)
    return {"result": "success"}

# Read
@app.route('/article', methods=['GET'])
def read_article():
    idx = request.args.get('idx')
    read_count = db.articles.find_one({'idx': int(idx)})['read_count']
    db.articles.update_one({'idx': int(idx)},{'$set':{'read_count': read_count + 1}})
    article = db.articles.find_one({'idx': int(idx)}, {'_id': 0})
    return jsonify({"article": article})

# Update
@app.route('/article', methods=['PUT'])
def update_article():
    # todo
    return {"result": "success"}

# Delete
@app.route('/article', methods=['DELETE'])
def delete_article():
    # todo
    return {"result": "success"}

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)