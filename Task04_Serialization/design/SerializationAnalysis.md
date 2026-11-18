# Task A4 – What Should Be Serialized?

## A4.1 – Decide What to Persist

The Hostel object contains Room objects, and each Room
contains Resident objects.

Fields to serialize:
- Hostel name
- Room number
- Resident name
- Resident register number

Fields marked transient:
- Password: Sensitive information should not be stored.
- Database Connection: A live connection cannot be meaningfully
  serialized and restored.

When Hostel is serialized, Java automatically serializes its
reachable serializable objects in the object graph.

## A4.2 – Plan for Change

If a phone number field is added to Resident, old serialized
files may still be read when the class maintains a compatible
serialVersionUID.

The new phone number field receives its default value (null)
when an older file is loaded.

If serialVersionUID values are incompatible, Java throws
InvalidClassException.

## Alternative – CSV or JSON

CSV and JSON store data in a readable text format.

| Feature | Serialization | CSV / JSON |
|---|---|---|
| Format | Binary | Text |
| Readability | Low | High |
| Saving n residents | O(n) | O(n) |
| Loading n residents | O(n) | O(n) |
| Space | Generally compact | Often larger |
| New fields | Version compatibility needed | Easier to extend |

CSV is suitable for simple tabular records.
JSON is useful for structured and nested data.

## Conclusion

Serialization saves an entire object graph conveniently.
Sensitive fields and live resources should be excluded using
transient. CSV or JSON is preferable when interoperability
and human readability are important.