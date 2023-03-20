def simple_columnar_encode(text, c, fill):
    if fill == True:
        if not len(text) % c == 0:
            text = text + "X"
            return simple_columnar_encode (text, c, fill)
        else:
            return simple_columnar_encode_helper (text, c)
    else:
        return simple_columnar_encode_helper (text, c)

def simple_columnar_encode_helper(text, c):
    count = 0
    counters_counter = 0
    final_list = []
    while counters_counter < c:
        if count + 1 > len(text):
            counters_counter += 1
            count = counters_counter
        final_list.append (text [count: count + 1])
        count += c
    del final_list [len(final_list) - 1]
    joined = "".join (final_list)
    return joined


def simple_columnar_decode(text, c):
    splitting_to_sections = []
    for i in range (0, len(text), c):
        splitting_to_sections.append (text [i : i + c])
    mini_list = []
    big_list = []
    big_list_len = []
    switched_text = []
    for i in range (c):
        for each_section in splitting_to_sections:
            if len(each_section) >= i + 1:
                mini_list.append (each_section [i])
        big_list.append (mini_list)
        mini_list = []
    for i in big_list:
        big_list_len.append (len(i))
    counter = 0
    for i in big_list_len:
        switched_text.append (text [counter: i + counter])
        counter = counter + i
    final_decoded_text = ""
    for i in range (len(switched_text [0])):
        for part in switched_text:
            if len(part) >= i + 1:
                final_decoded_text = final_decoded_text + part [i]
    return final_decoded_text


def keyword_columnar_encode (text, keywd, fill):
    if fill == True:
        if not len(text) % len(keywd) == 0:
            text = text + "X"
            return keyword_columnar_encode (text, keywd, fill)
        else:
            return keyword_columnar_encode_helper (text, keywd)
    else:
        return keyword_columnar_encode_helper (text, keywd)

def keyword_columnar_encode_helper (text, keywd):
    bigger_list = []
    smaller_list = []
    organized_list_index = []
    organized_list = []
    condensing_to_string = []
    counter = 0
    for i in range (len(keywd)):
        for index, letter in enumerate(text):
            if index % len(keywd) == counter:
                smaller_list.append (letter)
        counter += 1
        bigger_list.append(smaller_list)
        smaller_list = []
        if counter == len(keywd):
            break
    sorted_keywd = sorted(keywd)
    for i in sorted_keywd:
        if keywd.index(i) in organized_list_index:
            organized_list_index.append(keywd.index(i, keywd.index(i) + 1))
        else:
            organized_list_index.append (keywd.index (i))
    for i in organized_list_index:
        organized_list.append (bigger_list[i])
    for i in organized_list:
        condensing_to_string.append ("".join(i))
    final_string = "".join(condensing_to_string)
    return final_string


print (keyword_columnar_encode("ILIKEFOOD", "ICE", False))
